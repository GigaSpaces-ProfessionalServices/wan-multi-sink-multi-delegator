/**
 * @author Svitlana_Pogrebna
 *
 */
package com.gigaspaces.gigapro;

import org.springframework.scheduling.annotation.Scheduled;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.context.GigaSpaceContext;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * A feeder bean starts a scheduled task that writes a new Data objects to the
 * space (in an unprocessed state).
 *
 * <p>
 * The space is injected into this bean using OpenSpaces support for @GigaSpaceContext
 * annotation.
 *
 * <p>
 * The scheduling uses the java.util.concurrent Scheduled Executor Service. It
 * is started and stopped based on Spring lifecycle events.
 */
public class Feeder {

    private static final Logger LOG = Logger.getLogger(Feeder.class.getName());

    private double rate = 100;
    private int batchSize = 100;
    private int objectCount = 10_000_000;
    
    @GigaSpaceContext
    private GigaSpace sourceSpace;
    
    @Async
    public void start(CountDownLatch lock) {
        try {
            lock.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            LOG.warning("--- Start of feeder threads was not synchronized");
        }
        LOG.info("--- STARTING FEEDER IN THREAD [" + Thread.currentThread().getName() + "] WITH RATE [" + rate + "] AND BATCH SIZE [" + batchSize + "]");
        long baseSleepTime = (long) (1000 / rate * batchSize);
        long batchStartTime = System.currentTimeMillis();

        for (int i = 0; i < objectCount; i++) {
            Object data = ObjectFactory.create(RandomClassSelector.get());
            sourceSpace.write(data);
            batchStartTime = sleep(i, batchSize, batchStartTime, baseSleepTime);
        }

        LOG.info("--- FEEDER WROTE " + objectCount + " objects");
    }
    
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(int objectCount) {
        this.objectCount = objectCount;
    }
    
    public static long sleep(int i, int BURST, long batchStartTime, long baseSleepTime) {
        if ((i % BURST == 0) && (i > 0)) {
            long batchEndTime = System.currentTimeMillis();
            long sleepTimeCycle = baseSleepTime - (batchEndTime - batchStartTime);
            if (sleepTimeCycle > 0) {
                try {
                    Thread.sleep(sleepTimeCycle);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                LOG.warning("can’t sustain TP!");
            }
            return System.currentTimeMillis();
        }
        return batchStartTime;
    }
}
