package com.zjb.spring.cloud.weather.job;

import com.zjb.spring.cloud.weather.service.CityClient;
import com.zjb.spring.cloud.weather.service.WeatherDataCollectionService;
import com.zjb.spring.cloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zjb
 * @date 2018/3/8.
 */
@Component
@EnableScheduling
public class WeatherDataSyncJob{

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityClient cityClient;

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Scheduled(fixedRate = 18_000)
    private void executeInternal(){
        logger.info("Weather Data Sync Job. Start");
        //TODO 改用城市数据微服务提供
        List<City> cityList = null;

        try {
            cityList = cityClient.listCity();
//            cityList = new ArrayList<>();
//            City city = new City();
//            city.setCityId("101280601");
//            cityList.add(city);
        } catch (Exception e) {
            logger.error("Exception!",e);
        }
        for(City city : cityList){
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId:"+cityId);
            weatherDataCollectionService.sysncDataByCityId(cityId);
        }

        logger.info("Weather Data Sync Job. End! ");
    }

}
