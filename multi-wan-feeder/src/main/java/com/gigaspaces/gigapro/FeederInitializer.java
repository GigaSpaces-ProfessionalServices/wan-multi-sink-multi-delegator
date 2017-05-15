package com.gigaspaces.gigapro;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Svitlana_Pogrebna
 *
 */
public class FeederInitializer implements InitializingBean {

    @Autowired
    private Feeder feeder;
    
    private final int count;
    
    public FeederInitializer(int count) {
        this.count = count;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            feeder.start(latch);
            latch.countDown();
        }
    }
}
