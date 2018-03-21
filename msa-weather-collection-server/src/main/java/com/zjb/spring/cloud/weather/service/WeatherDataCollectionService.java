package com.zjb.spring.cloud.weather.service;

/**
 * @author zjb
 * @date 2018/3/21.
 */
public interface WeatherDataCollectionService {
    /**
     * 根据城市id返回天气
     * @param cityId
     */
    void sysncDataByCityId(String cityId);
}
