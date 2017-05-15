package com.gigaspaces.gigapro;

import com.gigaspaces.cluster.activeelection.SpaceMode;
import org.openspaces.admin.Admin;
import org.openspaces.admin.AdminFactory;
import org.openspaces.admin.space.Space;
import org.openspaces.admin.space.SpacePartition;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Async;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class RedoLogSizeStatistics implements IRedoLogSizeStatistics, InitializingBean {

    private static final Logger LOG = Logger.getLogger(RedoLogSizeStatistics.class.getName());
    private int statsInterval = 5000; // in milliseconds

    private String spaceName;
    private String lookupLocator;

    private Space space;
    private SpacePartition[] partitions;

    private volatile boolean interrupted;

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    public void printRedoLogSize() {
        StringBuilder sb = new StringBuilder();
        long totalRedoLogSize = 0;
        for (int i = 0; i < partitions.length; i++) {
            SpacePartition partition = space.getPartition(i);
            long redoLogSize = partition.getPrimary().getStatistics().getReplicationStatistics().getOutgoingReplication().getRedoLogSize();
            totalRedoLogSize += redoLogSize;
            sb.append(" redo_log_size").append(partition.getPartitionId()).append(": ").append(redoLogSize);
        }
        sb.append(" total_redo_log_size: ").append(totalRedoLogSize);
        LOG.info(new Date() + " Space: " + spaceName + sb.toString());
    }

    @Async
    @Override
    public void start() {
        LOG.info("--- START COLLECTING REDO LOG SIZE STATISTICS FOR SPACE: " + spaceName);
        while (!interrupted) {
            try {
                printRedoLogSize();
                Thread.sleep(statsInterval);
            } catch (InterruptedException e) {
                LOG.warning(e.getMessage());
            }
        }
    }

    @Override
    public void stop() {
        interrupted = true;
    }

    private void init() {
        AdminFactory adminFactory = new AdminFactory();
        adminFactory.addLocator(lookupLocator);
        Admin admin = adminFactory.createAdmin();

        if (admin == null) {
            System.err.println(" ------> " + " Can't locate admin using locators: " + lookupLocator);
            throw new RuntimeException("Can't locate admin using locators: " + lookupLocator);
        }

        space = admin.getSpaces().waitFor(spaceName, 10, TimeUnit.SECONDS);

        if (space == null) {
            System.err.println(" ------> " + " Can't locate space " + spaceName);
            throw new RuntimeException("Can't locate space " + spaceName);
        }
        space.waitFor(space.getNumberOfInstances(), SpaceMode.PRIMARY, 10, TimeUnit.SECONDS);
        partitions = space.getPartitions();
    }

    public int getStatsInterval() {
        return statsInterval;
    }

    public void setStatsInterval(int statsInterval) {
        this.statsInterval = statsInterval;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getLookupLocator() {
        return lookupLocator;
    }

    public void setLookupLocator(String lookupLocator) {
        this.lookupLocator = lookupLocator;
    }
}
