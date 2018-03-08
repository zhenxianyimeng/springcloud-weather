package com.zjb.spring.cloud.weather.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 * @author zjb
 * @date 2018/3/8.
 */
public class WeatherDataSyncJob extends QuartzJobBean{

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Job");
    }

}
