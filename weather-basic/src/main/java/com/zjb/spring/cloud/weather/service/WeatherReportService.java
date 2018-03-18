package com.zjb.spring.cloud.weather.service;

import com.zjb.spring.cloud.weather.vo.Weather;

/**
 * @author zjb
 * @date 2018/3/18.
 */
public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}
