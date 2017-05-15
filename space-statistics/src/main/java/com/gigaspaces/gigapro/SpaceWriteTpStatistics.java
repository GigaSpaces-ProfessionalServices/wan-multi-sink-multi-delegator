package com.gigaspaces.gigapro;

import org.openspaces.core.cluster.ClusterInfo;

import org.openspaces.core.cluster.ClusterInfoAware;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * @author Svitlana_Pogrebna
 *
 */
public class SpaceWriteTpStatistics implements ClusterInfoAware {
    
    private static final Logger LOG = Logger.getLogger(SpaceWriteTpStatistics.class.getName());
    
    private ClusterInfo clusterInfo;
    
    private final DecimalFormat decimalFormat;
    
    private final AtomicInteger counterWrite = new AtomicInteger(0);
    
    /* should not be exposed */
    private int lastWriteCounter; 
    private long lastWriteTimeStamp = System.currentTimeMillis();
    
    public SpaceWriteTpStatistics() {
        decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(1);
        decimalFormat.setGroupingUsed(false);
    }
    
    @Scheduled(fixedRateString = "${stats.interval}")
    public void start() {
        LOG.info(new Date() + " Space: " + clusterInfo.getUniqueName() + " space_write_tp: " + decimalFormat.format(calculateWriteTP()));
    }
    
    public void incrementWriteCounter() {
        counterWrite.incrementAndGet();
    }
    
    private double calculateWriteTP() {
        long currentTime = System.currentTimeMillis();
        double interval = (double) (currentTime - lastWriteTimeStamp) / 1000;
        int operCount = counterWrite.get();
        double writeTP = (operCount - lastWriteCounter) / interval;
        lastWriteTimeStamp = currentTime;
        lastWriteCounter = operCount;
        return writeTP;
    }

    @Override
    public void setClusterInfo(ClusterInfo clusterInfo) {
        this.clusterInfo = clusterInfo;
    }
}
