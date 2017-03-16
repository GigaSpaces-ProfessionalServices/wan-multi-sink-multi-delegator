package com.gigaspaces.util.mirror.monitor;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import com.gigaspaces.sync.DataSyncOperation;
import com.gigaspaces.sync.OperationsBatchData;
import com.gigaspaces.sync.TransactionData;
import org.hibernate.SessionFactory;
import org.openspaces.admin.Admin;
import org.openspaces.admin.AdminFactory;
import org.openspaces.admin.space.Space;
import org.openspaces.admin.space.SpacePartition;
import org.openspaces.admin.space.events.SpaceModeChangedEventManager;
import org.openspaces.persistency.hibernate.DefaultHibernateSpaceSynchronizationEndpoint;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Mirror extends DefaultHibernateSpaceSynchronizationEndpoint implements InitializingBean, DisposableBean {

    public Mirror(SessionFactory sessionFactory, boolean useMerge) {
        super(sessionFactory, null, useMerge, true);
    }

    private DecimalFormat DEC_FORMAT;
    private int statsInterval = 5000; //in milliseconds
    private boolean debug;
    private final MirrorStats stats = new MirrorStats();
    private MBeanServer mbs;
    private ObjectName statsMbeanName;
    private SpaceModeListener spaceModeListener;
    private String spaceName;
    private Integer partitionId;
    private String lookupLocator;
    private SpaceModeChangedEventManager modeManager;

    private ScheduledExecutorService executorService;

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        DEC_FORMAT = new DecimalFormat();
        DEC_FORMAT.setMaximumFractionDigits(1);
        
        executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                stats.calculateGlobalTP();
                stats.calculateWriteTP();
                stats.calculateUpdateTP();
                stats.calculateTakeTP();
                showStats();
            }
        }, statsInterval, statsInterval, TimeUnit.MILLISECONDS);
    }

    @Override
    public void destroy() throws Exception {
        executorService.shutdownNow();
        if (mbs.isRegistered(statsMbeanName)) {
            mbs.unregisterMBean(statsMbeanName);
        }
    }

    @Override
    public void onTransactionSynchronization(TransactionData transactionData) {
        if (!isDebug()) {
            super.onTransactionSynchronization(transactionData);
        }
        executeBulk(transactionData.getTransactionParticipantDataItems());
    }

    @Override
    public void onOperationsBatchSynchronization(OperationsBatchData batchData) {
        if (!isDebug()) {
            super.onOperationsBatchSynchronization(batchData);
        }
        executeBulk(batchData.getBatchDataItems());
    }

    public void executeBulk(DataSyncOperation[] opers) {
        if (stats.globalCounter.get() == 0) {
            synchronized (this) {
                if (stats.globalCounter.get() == 0) {
                    init();
                }
            }
        }
        collectStats(opers);
    }

    private void collectStats(DataSyncOperation[] bulk) {
        for (DataSyncOperation dataSyncOperation : bulk) {
            stats.globalCounter.incrementAndGet();
            switch (dataSyncOperation.getDataSyncOperationType()) {
            case REMOVE:
                stats.counterTake.incrementAndGet();
                break;
            case WRITE:
                stats.counterWrite.incrementAndGet();
                break;
            case UPDATE:
                stats.counterUpdate.incrementAndGet();
                break;
            default:
                break;
            }
        }
    }

    private void showStats() {
        System.out.println(new Date() + " Mirror - " + spaceName + getSpaceInstanceId()
                + " Total TP:" + DEC_FORMAT.format(stats.getGlobalTP())
                + " Total C:" + stats.globalCounter.get()
                + " W C:" + stats.counterWrite.get() 
                + " U C:" + stats.counterUpdate.get() 
                + " T C:" + stats.counterTake.get() 
                + " W TP:" + DEC_FORMAT.format(stats.getWriteTP()) 
                + " U TP:" + DEC_FORMAT.format(stats.getUpdateTP()) 
                + " T TP:" + DEC_FORMAT.format(stats.getTakeTP())
                + " W MAX TP:" + DEC_FORMAT.format(stats.getMaxWriteTP()) 
                + " U MAX TP:" + DEC_FORMAT.format(stats.getMaxUpdateTP()) 
                + " T MAX TP:" + DEC_FORMAT.format(stats.getMaxTakeTP()));
    }

    private void init() {
        System.out.println("Mirror started!");

        AdminFactory adminFactory = new AdminFactory();
        adminFactory.addLocator(lookupLocator);
        Admin admin = new AdminFactory().createAdmin();

        if (admin == null) {
            System.err.println(" ------> " + " Can't locate admin");
            throw new RuntimeException("Can't locate admin");
        }

        Space space = admin.getSpaces().waitFor(spaceName, 10, TimeUnit.SECONDS);

        if (space == null) {
            System.err.println(" ------> " + " Can't locate space " + spaceName);
            throw new RuntimeException("Can't locate space " + spaceName);
        }

        SpacePartition partition = space.getPartition(getPartitionId());
        try {
            stats.setPartition(partition);
            modeManager = space.getSpaceModeChanged();
            spaceModeListener = new SpaceModeListener(space, stats, getPartitionId());
            modeManager.add(spaceModeListener);

            mbs = ManagementFactory.getPlatformMBeanServer();

            statsMbeanName = new ObjectName(Mirror.class.getPackage().getName() + ":type=MirrorStats,name=" + space.getName() + getSpaceInstanceId());
            mbs.registerMBean(stats, statsMbeanName);
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getLookupLocator() {
        return lookupLocator;
    }

    public void setLookupLocator(String lookupLocator) {
        this.lookupLocator = lookupLocator;
    }

    public Integer getPartitionId() {
        return partitionId;
    }

    public Integer getSpaceInstanceId() {
        return partitionId + 1;
    }

    public void setSpaceInstanceId(Integer spaceInstanceId) {
        this.partitionId = spaceInstanceId - 1;
    }

    public int getStatsInterval() {
        return statsInterval;
    }

    public void setStatsInterval(int statsInterval) {
        this.statsInterval = statsInterval;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
