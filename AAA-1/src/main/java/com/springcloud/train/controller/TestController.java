package com.springcloud.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.train.feign.FeignClientInter;
import com.springcloud.train.feign.FeignHystrixClientInter;
import com.springcloud.train.mail.MailService;

@RestController
//@DefaultProperties(defaultFallback = "defaultFallback")
public class TestController {

	@Value("${server.port}")
	private String port;
	@Autowired
	private FeignClientInter feignClientInter;
	@Autowired
	private MailService mailService;
	
	@Autowired
	private FeignHystrixClientInter feignHystrixClientInter;
	
	@GetMapping("/")
	public String test() {
		
		String redata = "Application名称：AAA； "
				+ "服务：AAA-1； "
				+ "端口号：" + this.port;
		
		return redata;
	}
	
	@GetMapping("/data")
	public String data() {
		
		String redata = "Application名称：AAA； "
				+ "服务：AAA-1； "
				+ "端口号：" + this.port + "；"
				+ "zuul: zuul test";
		
		return redata;
	}
	
	@GetMapping("/msg/{param}")
	public String param(@PathVariable("param") String param) {
		String data = feignClientInter.queryServiceMsg(param);
		return data;
	}
	
	/*
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
	})
	*/
	
	//修改默认超时时间3秒
	/*
	@HystrixCommand(commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
	})
	*/
	
	@HystrixCommand(fallbackMethod = "feignHystrixExce")
	@GetMapping("/feign/{param}")
	public String feignParam(@PathVariable("param") String param) {
		String data = feignHystrixClientInter.feignMsg(param);
		return data;
	}
	
	private String feignHystrixExce(@PathVariable("param") String param) {
		//mailService.sendSimpleMail("492587402@qq.com", "系统警报", "系统异常，请及时处理!");
		return "系统异常，请稍后再试，给你造成不便敬请谅解！";
	}
	
	private String defaultFallback() {
		return "系统默认异常返回，请稍后再试，给你造成不便敬请谅解！";
	}
}
