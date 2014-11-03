package com.agate.store;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation for Supermaket
 * 
 */
public class SupermarketImpl implements Supermarket {

	private Map<Character, Integer> cart;
	private Map<Character, Item> store = new HashMap<Character, Item>();
	
	public void addItemToStore(Character name, Item item) {
		store.put(name, item);
	}
	
	@Override
	public int checkout(String items) {
		int total = 0;
		if (items == null) {
			return total;
		}
		cart = SortAndValidateCart(items.toUpperCase());
		for (Map.Entry<Character, Integer> entry : cart.entrySet()){
			Item item = store.get(entry.getKey());
			if (item != null)
				total += item.calculateItemPrice(entry.getValue());
		}
		return total;
	}

	/**
	 * Sort the input and create a cart of items that are available in the store
	 * 
	 * @param input is a String containing items in the cart
	 * @return a HashMap containing item and its total count 
	 */
	private Map<Character, Integer> SortAndValidateCart(String input) {
		cart = new HashMap<Character, Integer>();
		
		for (int i = 0; i < input.length(); i++) {
			char key = input.charAt(i);
			if(cart.containsKey(key)) {
				Integer count = (Integer) cart.get(key);
				cart.put(key, ++count);
			} else {
				cart.put(key, Integer.valueOf(1));
			}
		}
		return cart;
	}
	
}
