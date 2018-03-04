package com.zjb.spring.cloud.weather.vo;

import java.io.Serializable;

/**
 * @author zjb
 * @date 2018/3/4.
 */
public class Forecast implements Serializable{
    private static final long serialVersionUID = 8869323161899255469L;

    private String date;

    private String high;

    private String fengli;

    private String low;

    private String fengxiang;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date='" + date + '\'' +
                ", high='" + high + '\'' +
                ", fengli='" + fengli + '\'' +
                ", low='" + low + '\'' +
                ", fengxiang='" + fengxiang + '\'' +
                '}';
    }
}
