package com.gigaspaces.util.mirror.monitor;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.IntrospectionException;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.ReflectionException;

import org.openspaces.admin.space.SpacePartition;

public class MirrorStats implements IMirrorStats, DynamicMBean {

    AtomicInteger counterWrite = new AtomicInteger(0);
    AtomicInteger counterUpdate = new AtomicInteger(0);
    AtomicInteger counterTake = new AtomicInteger(0);
    AtomicInteger globalCounter = new AtomicInteger(0);

    double writeTP;
    double takeTP;
    double updateTP;

    int lastWriteCounter;
    int lastUpdateCounter;
    int lastTakeCounter;

    long lastWriteTimeStamp;
    long lastUpdateTimeStamp;
    long lastTakeTimeStamp;

    long lastGlobalTPTimeStamp;

    SpacePartition partition;

    public void setPartition(SpacePartition partition) {
        this.partition = partition;
    }

    public AtomicInteger getCounterWrite() {
        return counterWrite;
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
        if (name.equals("WriteCount"))
            return getWriteCount();
        if (name.equals("TakeCount"))
            return getTakeCount();
        if (name.equals("UpdateCount"))
            return getUpdateCount();
        if (name.equals("UpdateTP"))
            return getUpdateTP();
        if (name.equals("WriteTP"))
            return getWriteTP();
        if (name.equals("TakeTP"))
            return getTakeTP();
        if (name.equals("GlobalCount"))
            return getGlobalCount();
        if (name.equals("PartitionRedoLogSize"))
            return getPartitionRedologSize();
        return null;
    }

    @Override
    public AttributeList getAttributes(String[] arg0) {
        return null;
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        MBeanAttributeInfo[] attributes = new MBeanAttributeInfo[8];

        Method getTakeCounterMethod = null;
        Method getUpdateCounterMethod = null;
        Method getWriteCounterMethod = null;
        Method getTakeTPMethod = null;
        Method getUpdateTPMethod = null;
        Method getWriteTPMethod = null;
        Method getGlobalCounterMethod = null;
        Method getRedoLogSizeMethod = null;

        try {
            getTakeCounterMethod = MirrorStats.class.getMethod("getTakeCount");
            getUpdateCounterMethod = MirrorStats.class.getMethod("getUpdateCount");
            getWriteCounterMethod = MirrorStats.class.getMethod("getWriteCount");

            getGlobalCounterMethod = MirrorStats.class.getMethod("getGlobalCount");

            getTakeTPMethod = MirrorStats.class.getMethod("getTakeTP");
            getUpdateTPMethod = MirrorStats.class.getMethod("getUpdateTP");
            getWriteTPMethod = MirrorStats.class.getMethod("getWriteTP");

            getRedoLogSizeMethod = MirrorStats.class.getMethod("getPartitionRedologSize");

        } catch (SecurityException e1) {
            e1.printStackTrace();
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        }
        try {
            attributes[0] = new MBeanAttributeInfo("WriteCount", "WriteCount", getWriteCounterMethod, null);
            attributes[1] = new MBeanAttributeInfo("TakeCount", "TakeCount", getTakeCounterMethod, null);
            attributes[2] = new MBeanAttributeInfo("UpdateCount", "UpdateCount", getUpdateCounterMethod, null);

            attributes[3] = new MBeanAttributeInfo("WriteTP", "WriteTP", getWriteTPMethod, null);
            attributes[4] = new MBeanAttributeInfo("TakeTP", "TakeTP", getTakeTPMethod, null);
            attributes[5] = new MBeanAttributeInfo("UpdateTP", "UpdateTP", getUpdateTPMethod, null);

            attributes[6] = new MBeanAttributeInfo("GlobalCount", "GlobalCount", getGlobalCounterMethod, null);

            attributes[7] = new MBeanAttributeInfo("PartitionRedoLogSize", "PartitionRedoLogSize", getRedoLogSizeMethod, null);

        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        MBeanInfo bi = new MBeanInfo("MirrorStats", "MirrorStats desc", attributes, null, null, null);
        return bi;
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

    @Override
    public double getWriteTP() {
        long currentTime = System.currentTimeMillis();
        double interval = (double) (currentTime - lastWriteTimeStamp) / 1000;
        writeTP = ((double) counterWrite.get() - (double) lastWriteCounter) / interval;
        lastWriteTimeStamp = currentTime;
        lastWriteCounter = counterWrite.get();
        return writeTP;
    }

    @Override
    public double getTakeTP() {
        long currentTime = System.currentTimeMillis();
        double interval = (double) (currentTime - lastTakeTimeStamp) / 1000;
        takeTP = ((double) counterTake.get() - (double) lastTakeCounter) / interval;
        lastTakeTimeStamp = currentTime;
        lastTakeCounter = counterTake.get();
        return takeTP;
    }

    @Override
    public double getUpdateTP() {
        long currentTime = System.currentTimeMillis();
        double interval = (double) (currentTime - lastUpdateTimeStamp) / 1000;
        updateTP = ((double) counterUpdate.get() - (double) lastUpdateCounter) / interval;
        lastUpdateTimeStamp = currentTime;
        lastUpdateCounter = counterUpdate.get();
        return updateTP;
    }

    @Override
    public int getGlobalCount() {
        return globalCounter.get();
    }

    @Override
    public long getPartitionRedologSize() {
        if (partition == null) {
            throw new IllegalStateException("'partition' should be set");
        }
        long redologSize = 0;
        ClassLoader orig = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(MirrorStats.class.getClassLoader());
            redologSize = partition.getPrimary().getStatistics().getReplicationStatistics().getOutgoingReplication().getRedoLogSize();
        } finally {
            Thread.currentThread().setContextClassLoader(orig);
        }
        return redologSize;
    }
}
