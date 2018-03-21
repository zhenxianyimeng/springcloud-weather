package com.zjb.spring.cloud.weather.config;

import com.sun.org.apache.xpath.internal.operations.String;
import com.zjb.spring.cloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zjb
 * @date 2018/3/8.
 */
@Configuration
public class QuartzConfiguration {

    private static final int TIME = 1800;
    //JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
        .storeDurably().build();
    }

    //Trigger
    @Bean
    public Trigger weatherDataSyncTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }
}
