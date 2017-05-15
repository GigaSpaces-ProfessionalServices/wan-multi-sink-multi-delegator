package com.gigaspaces.util.mirror.monitor;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Logger;

public class MirrorStats implements IMirrorStats {

    private static final Logger LOG = Logger.getLogger(MirrorStats.class.getName());

    private final String mirrorName;
    
    private AtomicInteger counterWrite = new AtomicInteger(0);
    private AtomicInteger counterUpdate = new AtomicInteger(0);
    private AtomicInteger counterTake = new AtomicInteger(0);
    private AtomicInteger globalCounter = new AtomicInteger(0);

    private ReadWriteLock writeOperationLock = new ReentrantReadWriteLock();
    private ReadWriteLock updateOperationLock = new ReentrantReadWriteLock();
    private ReadWriteLock takeOperationLock = new ReentrantReadWriteLock();
    private ReadWriteLock globalLock = new ReentrantReadWriteLock();
    
    private double maxWriteTP;
    private double maxTakeTP;
    private double maxUpdateTP;
    
    private double writeTP;
    private double takeTP;
    private double updateTP;
    private double globalTP;

    private int lastWriteCounter;
    private int lastUpdateCounter;
    private int lastTakeCounter;
    private int lastGlobalCounter;
    
    private long lastWriteTimeStamp;
    private long lastUpdateTimeStamp;
    private long lastTakeTimeStamp;
    private long lastGlobalTimeStamp;
    
    private DecimalFormat decimalFormat;
    
    public MirrorStats(String mirrorName) {
        this.mirrorName = mirrorName;
        decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(1);
        decimalFormat.setGroupingUsed(false);
    }
    
    @Scheduled(fixedRateString = "${stats.interval}")
    public void start() {
        calculateGlobalTP();
        calculateWriteTP();
        calculateUpdateTP();
        calculateTakeTP();
        showStats();
    }
    
    private void showStats() {
        LOG.info(new Date() + " Mirror: " + mirrorName
                + " write_tp: " + decimalFormat.format(getWriteTP()) 
                + " update_tp: " + decimalFormat.format(getUpdateTP()) 
                + " take_tp: " + decimalFormat.format(getTakeTP())
                + " max_write_tp: " + decimalFormat.format(getMaxWriteTP()) 
                + " max_update_tp: " + decimalFormat.format(getMaxUpdateTP()) 
                + " max_take_tp: " + decimalFormat.format(getMaxTakeTP())
                + " total_tp: " + decimalFormat.format(getGlobalTP()));
    }
    
    @Override
    public int getTakeCount() {
        return counterTake.get();
    }

    @Override
    public int getUpdateCount() {
        return counterUpdate.get();
    }

    @Override
    public int getWriteCount() {
        return counterWrite.get();
    }
    
    public void calculateWriteTP() {
        writeOperationLock.writeLock().lock();
        try {
            long currentTime = System.currentTimeMillis();
            double interval = (double) (currentTime - lastWriteTimeStamp) / 1000;
            int operCount = counterWrite.get();
            writeTP = (operCount - lastWriteCounter) / interval;
            maxWriteTP = Math.max(maxWriteTP, writeTP);
            lastWriteTimeStamp = currentTime;
            lastWriteCounter = operCount;
        } finally {
            writeOperationLock.writeLock().unlock();
        }
    }

    @Override
    public double getWriteTP() {
        writeOperationLock.readLock().lock();
        try {
            return writeTP;
        } finally {
            writeOperationLock.readLock().unlock();
        }
    }
    
    @Override
    public double getMaxWriteTP() {
        writeOperationLock.readLock().lock();
        try {
            return maxWriteTP;
        } finally {
            writeOperationLock.readLock().unlock();
        }
    }

    public void calculateTakeTP() {
        takeOperationLock.writeLock().lock();
        try {
            long currentTime = System.currentTimeMillis();
            double interval = (double) (currentTime - lastTakeTimeStamp) / 1000;
            int operCount = counterTake.get();
            takeTP = (operCount - lastTakeCounter) / interval;
            maxTakeTP = Math.max(maxTakeTP, takeTP);
            lastTakeTimeStamp = currentTime;
            lastTakeCounter = operCount;
        } finally {
            takeOperationLock.writeLock().unlock();
        }
    }
    
    @Override
    public double getTakeTP() {
        takeOperationLock.readLock().lock();
        try {
            return takeTP;
        } finally {
            takeOperationLock.readLock().unlock();
        }
    }

    @Override
    public double getMaxTakeTP() {
        takeOperationLock.readLock().lock();
        try {
            return maxTakeTP;
        } finally {
            takeOperationLock.readLock().unlock();
        }
    }
    
    public void calculateUpdateTP() {
        updateOperationLock.writeLock().lock();
        try {
            long currentTime = System.currentTimeMillis();
            double interval = (double) (currentTime - lastUpdateTimeStamp) / 1000;
            int operCount = counterUpdate.get();
            updateTP = (operCount - lastUpdateCounter) / interval;
            maxUpdateTP = Math.max(maxUpdateTP, updateTP);
            lastUpdateTimeStamp = currentTime;
            lastUpdateCounter = operCount;
        } finally {
            updateOperationLock.writeLock().unlock();
        }
    }
    
    @Override
    public double getUpdateTP() {
        updateOperationLock.readLock().lock();
        try {
            return updateTP;
        } finally {
            updateOperationLock.readLock().unlock();
        }
    }
    
    public void calculateGlobalTP() {
        globalLock.writeLock().lock();
        try {
            long currentTime = System.currentTimeMillis();
            double interval = (double) (currentTime - lastGlobalTimeStamp) / 1000;
            int operCount = globalCounter.get();
            globalTP = (operCount - lastGlobalCounter) / interval;
            lastGlobalTimeStamp = currentTime;
            lastGlobalCounter = operCount;
        } finally {
            globalLock.writeLock().unlock();
        }
    }
    
    public double getGlobalTP() {
        globalLock.readLock().lock();
        try {
            return globalTP;
        } finally {
            globalLock.readLock().unlock();
        }
    }
    
    @Override
    public double getMaxUpdateTP() {
        updateOperationLock.readLock().lock();
        try {
            return maxUpdateTP;
        } finally {
            updateOperationLock.readLock().unlock();
        }
    }

    @Override
    public int getGlobalCount() {
        return globalCounter.get();
    }

    @Override
    public void incrementWriteCount() {
        counterWrite.incrementAndGet();
    }

    @Override
    public void incrementTakeCount() {
        counterTake.incrementAndGet();
    }

    @Override
    public void incrementUpdateCount() {
       counterUpdate.incrementAndGet();
    }

    @Override
    public void incrementGlobalCount() {
        globalCounter.incrementAndGet();
    }
}
