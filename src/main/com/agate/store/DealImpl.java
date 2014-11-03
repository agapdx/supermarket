package com.agate.store;

public class DealImpl implements Deal {

	int quantity;
	double deal;
	
	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(int qty) {
		this.quantity = qty;
	}

	@Override
	public double getDeal() {
		return deal;
	}

	@Override
	public void setDeal(double deal) {
		this.deal = deal;
	}

}
