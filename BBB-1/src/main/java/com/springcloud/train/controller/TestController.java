package com.springcloud.train.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/")
	public String home() {
		
		String redata = "Application名称：BBB； "
				+ "服务：BBB-1； "
				+ "端口号：" + this.port;
		
		return redata;
	}
	
	@PostMapping("/serviceMsg")
	public String serviceMsg(@RequestParam("param") String param) {
		
		String redata = "Application名称：BBB； "
				+ "服务：BBB-1； "
				+ "端口号：" + this.port + "；"
				+ "信息：" + param;
		
		return redata;
	}
	
	
	@PostMapping("/feignMsg")
	public String feignMsg(@RequestParam("param") String param) {
		
		String redata = "Application名称：BBB； "
				+ "服务：BBB-1； "
				+ "端口号：" + this.port + "；"
				+ "信息：" + param;
		
		return redata;
	}
}
