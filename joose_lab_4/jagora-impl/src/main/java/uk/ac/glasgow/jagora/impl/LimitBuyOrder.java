package uk.ac.glasgow.jagora.impl;

import uk.ac.glasgow.jagora.BuyOrder;
import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TradeException;
import uk.ac.glasgow.jagora.Trader;

public class LimitBuyOrder implements BuyOrder {
	
	private Trader trader;
	private Stock stock;
	private Integer quantity;
	private Double price;

	public LimitBuyOrder(Trader trader, Stock stock, Integer quantity, Double price) {
		this.trader = trader;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}
	
	public String toString(){
		//TODO
		return null;
	}

	@Override
	public Trader getTrader() {
		return this.trader;
	}

	@Override
	public Stock getStock() {
		return this.stock;
	}

	@Override
	public Integer getRemainingQuantity() {
		return this.quantity;
	}

	@Override
	public void satisfyTrade(TickEvent<Trade> tradeEvent) throws TradeException {
		
		try{
			Trade trade = tradeEvent.getEvent();
			trade.execute();		
		}
		
		catch(TradeException e){
			throw e;
		}
		
	}

	@Override
	public void rollBackTrade(TickEvent<Trade> tradeEvent)
			throws TradeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(BuyOrder order) {
		if(this.price < order.getPrice()){
			return -1;
		}
		else if(this.price == order.getPrice()){
			return 0;
		}
		else{
			return 1;
		}
	}
}
