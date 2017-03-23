/**
 * @author Svitlana_Pogrebna
 *
 */
package com.gigaspaces.gigapro;

import com.gigaspaces.client.WriteModifiers;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.SpaceInterruptedException;
import org.openspaces.core.context.GigaSpaceContext;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * A feeder bean starts a scheduled task that writes a new Data objects to the space (in an
 * unprocessed state).
 *
 * <p>The space is injected into this bean using OpenSpaces support for @GigaSpaceContext
 * annotation.
 *
 * <p>The scheduling uses the java.util.concurrent Scheduled Executor Service. It is started and
 * stopped based on Spring lifecycle events.
 */
public class Feeder implements InitializingBean, DisposableBean {

    Logger log = Logger.getLogger(this.getClass().getName());

    private ScheduledExecutorService executorService;

    private long defaultDelay = 1000;
   
    private int threadCount = 1;
    private int taskCount = 1;
    private int objectCount = 100;
    
    @GigaSpaceContext
    private GigaSpace sourceSpace;
    
    private FeederTask feederTask;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("--- STARTING FEEDER WITH CYCLE [" + defaultDelay + "]");
        executorService = Executors.newScheduledThreadPool(threadCount);
        feederTask = new FeederTask();
        
        for (int i = 0; i < taskCount; i++) {
           executorService.scheduleAtFixedRate(feederTask, defaultDelay, defaultDelay,
                    TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void destroy() throws Exception {
        executorService.shutdownNow();
    }

    public class FeederTask implements Runnable {

        private AtomicLong counter = new AtomicLong();

        @Override
        public void run() {
            try {
                Object[] data = new Object[objectCount];
                for (int i = 0; i < objectCount; i++) {
                    data[i] = ObjectFactory.create(RandomClassSelector.get());
                    counter.incrementAndGet();
                }
                sourceSpace.writeMultiple(data, WriteModifiers.ONE_WAY);
                log.info("--- FEEDER thread: '" + Thread.currentThread().getName() + "' WROTE " + objectCount + " objects, the total count is + " + getCounter());
            } catch (SpaceInterruptedException e) {
                // ignore, we are being shutdown
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public long getCounter() {
            return counter.get();
        }
    }

    public void setDefaultDelay(long defaultDelay) {
        this.defaultDelay = defaultDelay;
    }

    public long getDefaultDelay() {
        return defaultDelay;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public int getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(int objectCount) {
        this.objectCount = objectCount;
    }
}

