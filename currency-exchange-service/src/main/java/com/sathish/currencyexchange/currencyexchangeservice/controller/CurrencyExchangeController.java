package com.sathish.currencyexchange.currencyexchangeservice.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.currencyexchange.currencyexchangeservice.bean.ExchangeValue;
import com.sathish.currencyexchange.currencyexchangeservice.repository.EchangeValueRepo;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EchangeValueRepo repo;
	
	@Autowired
	private Environment environment;
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchnageValue(@PathVariable String from,@PathVariable String to)
	{
	//	ExchangeValue exchangeValue = new ExchangeValue(1000,from,to,BigDecimal.valueOf(65));
		ExchangeValue exchangeValue = repo.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("the exchangeValue"+exchangeValue);
		return exchangeValue;
	}

}
