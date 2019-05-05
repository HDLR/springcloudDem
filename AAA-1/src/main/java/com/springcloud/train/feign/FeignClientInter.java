package com.springcloud.train.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BBB")
//@FeignClient(name = "BBB", url = "http://localhost:8011/serviceMsg")
//@FeignClient(value = "BBB", serviceId = "BBB-1", path = "/serviceMsg")
public interface FeignClientInter {
	
	@PostMapping("/serviceMsg")
    String queryServiceMsg(@RequestParam("param") String param);
	
	//如果采用@RequestBody是必须使用@PostMapping，采用@GetMapping会报错
}
