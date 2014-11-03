package com.agate.store;

/**
 * Interface to add special pricing for an Item
 *
 */
public interface Deal {
	
	/**
	 * @return the Quantity for which the deal is available
	 */
	public int getQuantity();
	
	/**
	 * Sets the quantity for which the deal is available
	 * 
	 * @param qty
	 */
	public void setQuantity(int qty);
	
	/**
	 * @return
	 */
	public double getDeal();
	
	/**
	 * @param price
	 */
	public void setDeal(double price);
}
