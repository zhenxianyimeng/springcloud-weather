package com.zjb.spring.cloud.weather.service;

import com.zjb.spring.cloud.weather.vo.City;

import java.util.List;

/**
 * @author zjb
 * @date 2018/3/11.
 */
public interface CityDataService {

    List<City> listCity() throws Exception;
}
