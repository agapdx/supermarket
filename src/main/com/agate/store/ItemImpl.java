package com.agate.store;

public class ItemImpl implements Item {

	char name;
	double price;
	Deal deal;
	
	@Override
	public char getName() {
		return name;
	}

	@Override
	public void setName(char name) {
		this.name = name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public Deal getDeal() {
		return deal;
	}

	@Override
	public void setDeal(Deal deal) {
		this.deal = deal;
	}
	
	@Override
	public double calculateItemPrice(int qty) {
		double dealprice = 0;
		double regularprice = 0; 
		if (deal != null) {
			dealprice = (qty / deal.getQuantity()) * deal.getDeal();
			regularprice = (qty % deal.getQuantity()) * price;
		} else {
			regularprice = qty * price;
		}
		
		double itemprice = dealprice + regularprice;
		return itemprice;
	}

}
