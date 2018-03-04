package com.zjb.spring.cloud.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjb.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author zjb
 * @date 2018/3/4.
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService{

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri){
        WeatherResponse resp = null;
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        String strBody = null;
        if(respString.getStatusCodeValue() == 200){
            strBody = respString.getBody();
        }

        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return weather;
    }
}
