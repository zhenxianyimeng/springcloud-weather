package com.zjb.spring.cloud.weather.service;

import com.zjb.spring.cloud.weather.vo.City;
import com.zjb.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zjb
 * @date 2018/6/4.
 */
@FeignClient("msa-weather-data-server")
public interface WeatherClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
