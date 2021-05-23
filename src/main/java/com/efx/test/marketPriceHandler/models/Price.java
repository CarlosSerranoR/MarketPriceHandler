package com.efx.test.marketPriceHandler.models;

public class Price {

	public static final String separator = ",";
	public static final double margin_price = 0.1;

	long id;
	String instrumentName;
	double bid;
	double ask;
	String timestamp;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInstrumentName() {
		return instrumentName;
	}
	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}
	public double getBid() {
		return bid;
	}
	public void setBid(double bid) {
		this.bid = bid;
	}
	public double getAsk() {
		return ask;
	}
	public void setAsk(double ask) {
		this.ask = ask;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(id).append(separator)
		.append(instrumentName).append(separator)
		.append(bid).append(separator)
		.append(ask).append(separator)
		.append(timestamp);		

		return sb.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if(this.id!=((Price) obj).getId()) return false;
		if(this.bid!=((Price) obj).getBid()) return false;
		if(this.ask!=((Price) obj).getAsk()) return false;
		if(!this.timestamp.equals(((Price) obj).getTimestamp())) return false;
		if(!this.instrumentName.equals(((Price) obj).getInstrumentName())) return false;
		return true;
	}
	
	



}
