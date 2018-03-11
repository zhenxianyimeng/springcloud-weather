package com.zjb.spring.cloud.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjb.spring.cloud.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author zjb
 * @date 2018/3/4.
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final long TIME_OUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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

    @Override
    public void SyncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    private void saveWeatherData(String uri) {
        String key = uri;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }

        ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
    }

    private WeatherResponse doGetWeather(String uri) {
        String key = uri;
        String strBody = null;
        WeatherResponse weather = null;
        ObjectMapper mapper = new ObjectMapper();
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        if (stringRedisTemplate.hasKey(key)) {
            logger.info("Redis has data");
            strBody = ops.get(key);
        } else {
            logger.info("Redis don't has data");

            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

            if (respString.getStatusCodeValue() == 200) {
                strBody = respString.getBody();
            }
            ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        }

        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            logger.error("Error", e);
        }
        return weather;
    }
}
