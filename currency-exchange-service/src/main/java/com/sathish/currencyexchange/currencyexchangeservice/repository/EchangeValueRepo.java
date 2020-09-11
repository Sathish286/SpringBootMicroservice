package com.sathish.currencyexchange.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.currencyexchange.currencyexchangeservice.bean.ExchangeValue;

public interface EchangeValueRepo extends JpaRepository<ExchangeValue, Integer> {
	
	
	ExchangeValue findByFromAndTo(String from ,String to);

}
