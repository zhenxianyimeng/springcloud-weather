package com.zjb.spring.cloud.weather.vo;

import java.io.Serializable;

/**
 * @author zjb
 * @date 2018/3/4.
 */
public class WeatherResponse implements Serializable{
    private static final long serialVersionUID = -16226777052162855L;

    private Weather data;

    private Integer status;

    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "data=" + data +
                ", status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
