package com.agate.store;

/**
 * Interface for an Item
 *
 */
public interface Item {
	
	/**
	 * @return name of the Item
	 */
	public char getName();
	
	/**
	 * Sets the name of the Item
	 * @param name
	 */
	public void setName(char name);
	
	/**
	 * @return the price of a single Item
	 */
	public double getPrice();
	
	/**
	 * Sets teh price of a single Item
	 * @param price
	 */
	public void setPrice(double price);
	
	/**
	 * @return the Special Deal if any
	 */
	public Deal getDeal();
	
	/**
	 * Sets a special Deal for this Item
	 * @param deal
	 */
	public void setDeal(Deal deal);
	
	/**
	 * Calculate the price for a given Item taking into account any special deal
	 * @param qty quantity of the Items in the shopping cart
	 * @return Total price for all the Items, taking into account any deal price
	 */
	public double calculateItemPrice(int qty);
}
