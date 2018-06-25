package com.zjb.spring.cloud.weather.service;

import com.zjb.spring.cloud.weather.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author zjb
 * @date 2018/6/4.
 */
@FeignClient("msa-weather-city-server")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
