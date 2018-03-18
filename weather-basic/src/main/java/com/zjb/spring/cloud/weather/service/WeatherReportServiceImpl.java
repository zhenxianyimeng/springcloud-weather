package com.zjb.spring.cloud.weather.service;

import com.zjb.spring.cloud.weather.vo.Weather;
import com.zjb.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjb
 * @date 2018/3/18.
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService{

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
        return resp.getData();
    }
}
