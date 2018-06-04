package com.zjb.spring.cloud.weather.controller;

import com.zjb.spring.cloud.weather.service.CityClient;
import com.zjb.spring.cloud.weather.service.WeatherReportService;
import com.zjb.spring.cloud.weather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjb
 * @date 2018/3/4.
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    private final Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private CityClient cityClient;

    @Autowired
    private WeatherReportService weatherReportService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId,
                                          Model model) throws Exception {
       //TODO 改为城市数据API微服务提供数据
        //TODO 改用城市数据微服务提供
        List<City> cityList = null;

        try {
            cityList = cityClient.listCity();
//            City city = new City();
//            city.setCityId("101280601");
//            city.setCityName("深圳");
//            cityList.add(city);
        } catch (Exception e) {
            logger.error("Exception!",e);
        }
        model.addAttribute("title","天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
