package com.efx.test.marketPriceHandler.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efx.test.marketPriceHandler.consumer.ConsumerMessageListener;
import com.efx.test.marketPriceHandler.consumer.PriceFeedStore;
import com.efx.test.marketPriceHandler.models.Message;


@RestController
@RequestMapping(value = "/price-feed/")
public class PriceController {

	@Autowired
	PriceFeedStore priceFeedStore;

	@Autowired
	ConsumerMessageListener consumerMessageListener;
	
	@GetMapping(value = "/getLastFeed")
	public String getLastFeed(@RequestParam("instrumentName") String instrumentName) {		
		String result=priceFeedStore.getPriceFeedMap().get(instrumentName)!=null?priceFeedStore.getPriceFeedMap().get(instrumentName).toString():"There is no results for input: "+instrumentName;
		System.out.println("getLastFeed?"+instrumentName+": "+result);
		return result;
	}

	@PostMapping(value="/recieveFeed")
	public void recieveFeed(@RequestBody Message feed) {	

		consumerMessageListener.onMessage(feed.getFeed());

	}

}
