package com.zjb.spring.cloud.weather.service;

import com.zjb.spring.cloud.weather.vo.WeatherResponse;

/**
 * @author zjb
 * @date 2018/3/4.
 */
public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);
}
