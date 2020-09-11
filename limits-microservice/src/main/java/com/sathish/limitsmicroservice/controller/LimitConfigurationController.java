package com.sathish.limitsmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.limitsmicroservice.Configuration.Configuration;
import com.sathish.limitsmicroservice.bean.LimitConfiguration;

@RestController
public class LimitConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration()
	{
		LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMaximum(),
				configuration.getMinimum());
		return limitConfiguration;
	}

}
