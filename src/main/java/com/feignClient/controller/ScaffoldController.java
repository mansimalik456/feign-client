package com.feignClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feignClient.client.ScaffoldClient;

@RestController
@RequestMapping("/feignClient")
public class ScaffoldController {
	
	@Autowired ScaffoldClient scaffoldClient;
	
	@GetMapping("/v1/management/user/{userId}")
	public ResponseEntity<Object> getUserById(@PathVariable long userId, @RequestHeader("Authorization") String accessToken) {
		Object data = scaffoldClient.getUserById(userId, accessToken);
		return new ResponseEntity<Object>(data, HttpStatus.OK);
	}

}
