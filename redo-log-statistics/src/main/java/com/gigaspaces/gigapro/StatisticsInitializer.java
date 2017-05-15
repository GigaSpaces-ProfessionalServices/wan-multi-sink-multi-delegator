package com.gigaspaces.gigapro;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.List;

/**
 * @author Svitlana_Pogrebna
 *
 */
@Configurable(autowire = Autowire.BY_TYPE)
public class StatisticsInitializer implements InitializingBean, DisposableBean {

    @Autowired
    private List<IRedoLogSizeStatistics> allStatisticBeans;

    @Override
    public void afterPropertiesSet() throws Exception {
        for (IRedoLogSizeStatistics redoLogSizeStatistics : allStatisticBeans) {
            redoLogSizeStatistics.start();
        }
    }

    @Override
    public void destroy() throws Exception {
        for (IRedoLogSizeStatistics redoLogSizeStatistics : allStatisticBeans) {
            redoLogSizeStatistics.stop();
        }
    }
}
