package com.efx.test.marketPriceHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.efx.test.marketPriceHandler.models.Price;
import com.efx.test.marketPriceHandler.utils.PriceFeedUtil;

@SpringBootTest
public class PriceTest {
	
	@Autowired
	PriceFeedUtil util;
	
	@Test
	void getPriceFromString() {
		String priceString="106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001";
		Price priceRes=new Price();
		priceRes.setId(106);
		priceRes.setAsk(1.2000);
		priceRes.setBid(1.1000);
		priceRes.setInstrumentName("EUR/USD");
		priceRes.setTimestamp("01-06-2020 12:01:01:001");
		
		assertEquals(priceRes, util.getPriceFromString(priceString));
	}


	@Test
	void calculateMarginAsk() {
		Price price=new Price();
		price.setId(106);
		price.setAsk(1.0);
		price.setBid(1.0);
		price.setInstrumentName("EUR/USD");
		price.setTimestamp("01-06-2020 12:01:01:001");
		Price priceCalc=util.calculateMarginPrice(price, Price.margin_price);
		assertEquals(priceCalc.getAsk(), 1.1);

	}
	
	
	@Test
	void calculateMarginAskZero() {
		Price price=new Price();
		price.setId(106);
		price.setAsk(1.0);
		price.setBid(1.0);
		price.setInstrumentName("EUR/USD");
		price.setTimestamp("01-06-2020 12:01:01:001");
		Price priceCalc=util.calculateMarginPrice(price, 0);
		assertEquals(priceCalc.getAsk(), 1.0);

	}
	

	@Test
	void calculateMarginBidZero() {
		Price price=new Price();
		price.setId(106);
		price.setAsk(1.0);
		price.setBid(1.0);
		price.setInstrumentName("EUR/USD");
		price.setTimestamp("01-06-2020 12:01:01:001");
		Price priceCalc=util.calculateMarginPrice(price, 0);
		assertEquals(priceCalc.getBid(), 1.0);

	}
}
