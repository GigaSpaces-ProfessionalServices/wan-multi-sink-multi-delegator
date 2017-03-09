package com.gigaspaces.util.mirror.monitor;

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
import java.util.concurrent.TimeUnit;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class Mirror extends DefaultHibernateSpaceSynchronizationEndpoint {
    
    public Mirror(SessionFactory sessionFactory, boolean useMerge) {
        super(sessionFactory, null, useMerge, true);
    }

    DecimalFormat DEC_FORMAT;
    int REPORT_SAMPLING_INTERVAL = 1000;
    
    MirrorStats stats = new MirrorStats();
    MBeanServer mbs;
    ObjectName statsMeabnName;
    SpaceModeListener spaceModeListener;
    String spaceName;
    Integer partitionId;
    String lookupLocator;
    SpaceModeChangedEventManager modeManager;

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	long lastReading = System.currentTimeMillis();
	
	@Override
    public void onTransactionSynchronization(TransactionData transactionData) {
        super.onTransactionSynchronization(transactionData);
        executeBulk(transactionData.getTransactionParticipantDataItems());
    }

    @Override
    public void onOperationsBatchSynchronization(OperationsBatchData batchData) {
        super.onOperationsBatchSynchronization(batchData);
        executeBulk(batchData.getBatchDataItems());
    }

    public void executeBulk(DataSyncOperation[] opers) {
        if (stats.globalCounter.get() == 0) {
            synchronized(this) {
                if (stats.globalCounter.get() == 0) {
                    init();
                }
            }
        }
        
		collectStats(opers);
	    showStats();
	}
	
    void collectStats(DataSyncOperation[] bulk) {
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
	
    void showStats() {
        int _count = stats.globalCounter.get();
        if (_count % REPORT_SAMPLING_INTERVAL == 0) {
            long currentTime = System.currentTimeMillis();
            double interval = (double) (currentTime - lastReading) / 1000;
            double currentGlobalTP = REPORT_SAMPLING_INTERVAL / interval;
			
			System.out.println(new Date (currentTime)+ 
					" Mirror - Total TP:"+ DEC_FORMAT.format(currentGlobalTP) +
					" C:"+  _count+		
					" W C:"+ stats.counterWrite.get()+		
					" U C:"+ stats.counterUpdate.get() +
					" T C:"+ stats.counterTake.get()	+
					" W TP:"+ DEC_FORMAT.format(stats.getWriteTP()) +		
					" U TP:"+ DEC_FORMAT.format(stats.getUpdateTP()) +		
					" T TP:"+ DEC_FORMAT.format(stats.getTakeTP())	
			);
            lastReading = currentTime;
        }
	}
	
    private void init() {
        System.out.println("Mirror started!");
        DEC_FORMAT = new DecimalFormat();
        DEC_FORMAT.setMaximumFractionDigits(1);

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

            // Construct the ObjectName for the MBean we will register
            statsMeabnName = new ObjectName(Mirror.class.getPackage().getName() + ":type=MirrorStats,name=" + space.getName() + getSpaceInstanceId());
            mbs.registerMBean(stats, statsMeabnName);
        } catch(InstanceAlreadyExistsException e) {
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
}
