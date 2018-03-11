package com.zjb.spring.cloud.weather.service;

import com.zjb.spring.cloud.weather.util.XmlBuilder;
import com.zjb.spring.cloud.weather.vo.City;
import com.zjb.spring.cloud.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author zjb
 * @date 2018/3/11.
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        //读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = br.readLine()) != null){
            buffer.append(line);
        }
        br.close();

        //XML 转为JAVA对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
