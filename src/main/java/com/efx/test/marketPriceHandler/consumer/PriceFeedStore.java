package com.efx.test.marketPriceHandler.consumer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.efx.test.marketPriceHandler.models.Price;

@Component
public class PriceFeedStore {


	Map<String,Price> priceFeedMap = new  HashMap<>();

	public Map<String, Price> getPriceFeedMap() {
		return priceFeedMap;
	}

	public void setPriceFeedMap(Map<String, Price> priceFeedMap) {
		this.priceFeedMap = priceFeedMap;
	}

	



}
