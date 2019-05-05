package com.springcloud.train.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BBB")
public interface FeignHystrixClientInter {
	
	@PostMapping("/feignMsg")
    String feignMsg(@RequestParam("param") String param);
}
