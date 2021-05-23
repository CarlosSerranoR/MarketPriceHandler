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
		for (int i = 0; i < priceArr.length; i++) {
			if(i==0) { 
				price.setId(Long.valueOf(priceArr[i]));
				continue;
			}
			if(i==1) {
				price.setInstrumentName(priceArr[i].trim());
				continue;
			}
			if(i==2) { 
				price.setBid(Double.valueOf(priceArr[i]));
				continue;
			}
			if(i==3) { 
				price.setAsk(Double.valueOf(priceArr[i]));
				continue;
			}
			if(i==4) { 
				price.setTimestamp(priceArr[i].trim());
				continue;
			}
		}
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
