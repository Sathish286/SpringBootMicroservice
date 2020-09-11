package com.sathish.currencyexchangeservice.currencyconversionservice.fiegn;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.sathish.currencyexchangeservice.currencyconversionservice.bean.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
@Component
public interface CurrencyExchangeServiceProxy {

	
	@GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchnageValue(@PathVariable("from") String from,@PathVariable("to") String to);
	
}
