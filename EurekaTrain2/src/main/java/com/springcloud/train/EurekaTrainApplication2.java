package com.springcloud.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaTrainApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaTrainApplication2.class, args);
	}

}

