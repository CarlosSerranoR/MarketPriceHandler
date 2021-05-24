package com.efx.test.marketPriceHandler.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.efx.test.marketPriceHandler.models.Price;

@Component
public class PriceFeedUtil {

	public List<Price> processFeed(String[] incomingFeed) {
		List<Price> priceList = new ArrayList<>();
		for (int i = 0; i < incomingFeed.length; i++) {
			priceList.add(calculateMarginPrice(getPriceFromString(incomingFeed[i]),Price.margin_price));
		}
		return priceList;
	}


	public Price getPriceFromString(String priceString) {
		Price price= new Price();
		String[] priceArr = priceString.split(Price.separator);

		price.setId(Long.valueOf(priceArr[0]));
		price.setInstrumentName(priceArr[1].trim());
		price.setBid(Double.valueOf(priceArr[2]));
		price.setAsk(Double.valueOf(priceArr[3]));
		price.setTimestamp(priceArr[4].trim());

		return price;

	}

	public Price calculateMarginPrice(Price price, double margin) {
		double askComission=price.getAsk() + price.getAsk()*margin;
		price.setAsk(askComission);

		double bidComission=price.getBid() - price.getBid()*margin;
		price.setBid(bidComission);
		return price;

	}

}
