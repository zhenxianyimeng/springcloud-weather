package com.zjb.spring.cloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaWeatherCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaWeatherCollectionApplication.class, args);
	}
}
