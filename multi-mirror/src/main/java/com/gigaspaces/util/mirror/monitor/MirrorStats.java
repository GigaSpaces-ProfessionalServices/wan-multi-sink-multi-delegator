package com.gigaspaces.util.mirror.monitor;

import org.openspaces.admin.space.Space;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.management.*;

public class MirrorStats implements IMirrorStats, DynamicMBean {

    AtomicInteger counterWrite = new AtomicInteger(0);
    AtomicInteger counterUpdate = new AtomicInteger(0);
    AtomicInteger counterTake = new AtomicInteger(0);
    AtomicInteger globalCounter = new AtomicInteger(0);

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
    
    private Space space;
    private int partitionIndex;
    
    public void setSpace(Space space) {
        this.space = space;
    }
    
    public void setPartitionIndex(int partitionIndex) {
        this.partitionIndex = partitionIndex;
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

    @Override
    public Object getAttribute(String name) throws AttributeNotFoundException, MBeanException, ReflectionException {
        switch(name) {
            case "WriteCount": return getWriteCount();
            case "TakeCount": return getTakeCount();
            case "UpdateCount": return getUpdateCount();
            case "WriteTP": return getWriteTP();
            case "TakeTP": return getTakeTP();
            case "UpdateTP": return getUpdateTP();
            case "MaxWriteTP": return getMaxWriteTP();
            case "MaxTakeTP": return getMaxTakeTP();
            case "MaxUpdateTP": return getMaxUpdateTP();
            case "GlobalCount": return getGlobalCount();
            case "PartitionRedoLogSize": return getPartitionRedologSize();
            default: return null;
        }
    }

    @Override
    public AttributeList getAttributes(String[] arg0) {
        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        MBeanAttributeInfo[] attributes = new MBeanAttributeInfo[11];

        try {
            attributes[0] = new MBeanAttributeInfo("WriteCount", "WriteCount", MirrorStats.class.getMethod("getWriteCount"), null);
            attributes[1] = new MBeanAttributeInfo("TakeCount", "TakeCount", MirrorStats.class.getMethod("getTakeCount"), null);
            attributes[2] = new MBeanAttributeInfo("UpdateCount", "UpdateCount", MirrorStats.class.getMethod("getUpdateCount"), null);

            attributes[3] = new MBeanAttributeInfo("WriteTP", "WriteTP", MirrorStats.class.getMethod("getWriteTP"), null);
            attributes[4] = new MBeanAttributeInfo("TakeTP", "TakeTP", MirrorStats.class.getMethod("getTakeTP"), null);
            attributes[5] = new MBeanAttributeInfo("UpdateTP", "UpdateTP", MirrorStats.class.getMethod("getUpdateTP"), null);
            
            attributes[6] = new MBeanAttributeInfo("MaxWriteTP", "MaxWriteTP", MirrorStats.class.getMethod("getMaxWriteTP"), null);
            attributes[7] = new MBeanAttributeInfo("MaxTakeTP", "MaxTakeTP", MirrorStats.class.getMethod("getMaxTakeTP"), null);
            attributes[8] = new MBeanAttributeInfo("MaxUpdateTP", "MaxUpdateTP", MirrorStats.class.getMethod("getMaxUpdateTP"), null);

            attributes[9] = new MBeanAttributeInfo("GlobalCount", "GlobalCount", MirrorStats.class.getMethod("getGlobalCount"), null);

            attributes[10] = new MBeanAttributeInfo("PartitionRedoLogSize", "PartitionRedoLogSize", MirrorStats.class.getMethod("getPartitionRedologSize"), null);

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }  catch (SecurityException e1) {
            e1.printStackTrace();
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        }

       return new MBeanInfo("MirrorStats", "MirrorStats desc", attributes, null, null, null);
    }

    @Override
    public Object invoke(String arg0, Object[] arg1, String[] arg2) throws MBeanException, ReflectionException {
        return null;
    }

    @Override
    public void setAttribute(Attribute arg0) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {

    }

    @Override
    public AttributeList setAttributes(AttributeList arg0) {
        return null;
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
    public long getPartitionRedologSize() {
        return getPartitionRedologSize(partitionIndex);
    }
    
    public long getPartitionRedologSize(int index) {
        if (space == null) {
            return 0;
        }
        long redologSize = 0;
        ClassLoader orig = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(MirrorStats.class.getClassLoader());
            redologSize = space.getPartition(index).getPrimary().getStatistics().getReplicationStatistics().getOutgoingReplication().getRedoLogSize();
        } finally {
            Thread.currentThread().setContextClassLoader(orig);
        }
        return redologSize;
    }
}
