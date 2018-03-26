package com.zjb.spring.cloud.weather.service;

import com.zjb.spring.cloud.weather.vo.Forecast;
import com.zjb.spring.cloud.weather.vo.Weather;
import com.zjb.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjb
 * @date 2018/3/18.
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService{

    @Override
    public Weather getDataByCityId(String cityId) {
        //TODO 天气数据API微服务提供数据
        Weather data= new Weather();
        data.setAqi("81");
        data.setCity("深圳");
        data.setGanmao("容易感冒！多穿衣");
        data.setWendu("22");
        List<Forecast> forecastList = new ArrayList<>();
        Forecast forecast = new Forecast();
        forecast.setDate("29日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温11度");
        forecast.setLow("低温1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("25日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温11度");
        forecast.setLow("低温1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("26日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温11度");
        forecast.setLow("低温1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("27日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温11度");
        forecast.setLow("低温1度");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("28日星期天");
        forecast.setType("晴");
        forecast.setFengxiang("无风");
        forecast.setHigh("高温11度");
        forecast.setLow("低温1度");
        forecastList.add(forecast);

        data.setForecast(forecastList);
//        WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
        return data;
    }
}
