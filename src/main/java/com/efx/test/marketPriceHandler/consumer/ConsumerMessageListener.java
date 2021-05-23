package com.efx.test.marketPriceHandler.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.efx.test.marketPriceHandler.models.Price;
import com.efx.test.marketPriceHandler.utils.PriceFeedUtil;
 
@Service
public class ConsumerMessageListener  {

	@Value("${cvs.line-separator}")
	String lineSeparator;
	
	@Autowired
	PriceFeedUtil priceFeedUtil;
	
	@Autowired
	PriceFeedStore priceFeedStore;

	public void onMessage(String message) {
		System.out.println("Message received: "+message);
		String priceFeed=new String(message);
		String[] priceFeedArr = priceFeed.split(lineSeparator);
		List<Price> listPriceFeed = priceFeedUtil.processFeed(priceFeedArr);
		for(Price price:listPriceFeed) {
			priceFeedStore.getPriceFeedMap().put(price.getInstrumentName(), price);
		}
	}	
 
}