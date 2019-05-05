package com.springcloud.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulTrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulTrainApplication.class, args);
	}

}

