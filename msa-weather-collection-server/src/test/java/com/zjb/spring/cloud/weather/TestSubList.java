package com.zjb.spring.cloud.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjb
 * @date 2018/3/13.
 */
public class TestSubList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list = list.subList(0,2);
        System.out.println(list.size());
    }
}
