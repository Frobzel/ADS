package uk.ac.glasgow.jagora.impl;

import uk.ac.glasgow.jagora.BuyOrder;
import uk.ac.glasgow.jagora.SellOrder;
import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TradeException;
import uk.ac.glasgow.jagora.World;

public class DefaultTrade implements Trade {

	private World world;
	private BuyOrder buyOrder;
	private SellOrder sellOrder;
	private Integer quantity;
	private Stock stock;
	private Double price;

	public DefaultTrade(World world, BuyOrder buyOrder, SellOrder sellOffer, Stock stock, Integer quantity, Double price) {
		this.world = world;
		this.buyOrder = buyOrder;
		this.sellOrder = sellOffer;
		this.stock = stock;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public Stock getStock() {
		return stock;
	}

	@Override
	public Integer getQuantity() {
		return quantity;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public TickEvent<Trade> execute() throws TradeException {		
		return null;
	}
	
	public String toString(){
		//TODO
		return null;
	}

}