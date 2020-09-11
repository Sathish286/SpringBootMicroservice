package com.sathish.currencyexchangeservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sathish.currencyexchangeservice.currencyconversionservice.bean.CurrencyConversionBean;
import com.sathish.currencyexchangeservice.currencyconversionservice.fiegn.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyConversion(
			@PathVariable String from ,@PathVariable String to,@PathVariable BigDecimal quantity)
	{
		Map<String,String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CurrencyConversionBean> responseEntity=restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,uriVariable);
		//System.err.println(responseEntity.toString());
		CurrencyConversionBean response= responseEntity.getBody();
		CurrencyConversionBean currencyConversionBean =new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), 
				quantity,quantity.multiply(response.getConversionMultiple()),
				response.getPort());
		return currencyConversionBean;
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyConversionFeign(
			@PathVariable String from ,@PathVariable String to,@PathVariable BigDecimal quantity)
	{
		CurrencyConversionBean response = proxy.retrieveExchnageValue(from, to);
		CurrencyConversionBean currencyConversionBean =new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), 
				quantity,quantity.multiply(response.getConversionMultiple()),
				response.getPort());
		logger.info("response{}"+ response);
		return currencyConversionBean;
	}
}
