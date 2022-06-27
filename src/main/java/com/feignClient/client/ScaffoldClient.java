package com.feignClient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "communication-scaffold-service", url="localhost:8080")
public interface ScaffoldClient {
	
//	@GetMapping(UrlConstants.GET_USER)
	@GetMapping("/v1/management/user/{userId}")
	public Object getUserById(@PathVariable long userId, @RequestHeader("Authorization") String accessToken);
	
}
