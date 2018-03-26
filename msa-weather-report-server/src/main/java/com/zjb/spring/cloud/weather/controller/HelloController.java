package com.zjb.spring.cloud.weather.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjb
 * @date 2018/2/23.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @PostMapping("/test")
    public String test(@RequestBody String str){
        System.out.println(str);
        return "success";
    }

}
