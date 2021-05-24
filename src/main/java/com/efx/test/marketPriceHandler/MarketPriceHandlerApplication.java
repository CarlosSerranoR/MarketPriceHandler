package com.efx.test.marketPriceHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.efx.test.marketPriceHandler.Controller.PriceController;
import com.efx.test.marketPriceHandler.models.Message;

@SpringBootApplication
public class MarketPriceHandlerApplication	 implements CommandLineRunner  {

	@Autowired
	PriceController priceController;

	public static void main(String[] args) {
		SpringApplication.run(MarketPriceHandlerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Message message= new Message();
		message.setFeed("106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001");
		priceController.recieveFeed(message);
		message.setFeed("107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002");
		priceController.recieveFeed(message);
		message.setFeed("108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002");
		priceController.recieveFeed(message);
		message.setFeed("110, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110");
		priceController.recieveFeed(message);
		message.setFeed("109, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100");
		
		priceController.recieveFeed(message);
		message.setFeed("111, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n112, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002\n113, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002\n114, GBP/USD, 1.2499,1.2561,01-06-2020 12:01:02:100\n115, EUR/JPY, 119.61,119.91,01-06-2020 12:01:02:110");
		
		priceController.recieveFeed(message);
		priceController.getLastFeed("EUR/JPY");
		priceController.getLastFeed("GBP/USD");
	}


}
