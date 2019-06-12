package com.stackroute.muzixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@EnableEurekaClient
@SpringBootApplication
public class TrackDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackDemoApplication.class, args);
	}

}
