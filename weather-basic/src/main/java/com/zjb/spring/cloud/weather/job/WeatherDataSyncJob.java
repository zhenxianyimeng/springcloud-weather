package com.zjb.spring.cloud.weather.job;

import com.zjb.spring.cloud.weather.service.CityDataService;
import com.zjb.spring.cloud.weather.service.WeatherDataService;
import com.zjb.spring.cloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;


/**
 * @author zjb
 * @date 2018/3/8.
 */
public class WeatherDataSyncJob extends QuartzJobBean{

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Job. Start");
        List<City> cityList = null;

        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            logger.error("Exception!",e);
        }
        for(City city : cityList){
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId:"+cityId);
            weatherDataService.SyncDataByCityId(cityId);
        }

        logger.info("Weather Data Sync Job. End! ");
    }

}
