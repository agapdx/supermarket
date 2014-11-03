package com.agate.store;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.agate.store.Deal;
import com.agate.store.DealImpl;
import com.agate.store.Item;
import com.agate.store.ItemImpl;
import com.agate.store.SupermarketImpl;

public class SuperMarketImplTest {

	private static SupermarketImpl market;
	private static Item a,b,c;

	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		a = new ItemImpl();
		a.setName('A');
		a.setPrice(20);

		b = new ItemImpl();
		b.setName('B');
		b.setPrice(50);
		Deal deal = new DealImpl();
		deal.setQuantity(5);
		deal.setDeal(150);
		b.setDeal(deal);
		
		c = new ItemImpl();
		c.setName('C');
		c.setPrice(30);

		market = new SupermarketImpl();
		market.addItemToStore('A', a);
		market.addItemToStore('B', b);
		market.addItemToStore('C', c);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		a = null;
		b = null;
		c = null;
		market = null;
	}
	
	@Before
    public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCart() {
		Assert.assertEquals(240, market.checkout("ABBACBBAB"));
	}

	@Test
	public void testA() {
		Assert.assertEquals(20, market.checkout("A"));
	}
	
	@Test
	public void testLowercase() {
		Assert.assertEquals(100, market.checkout("abc"));
	}
	
	@Test
	public void testB() {
		Assert.assertEquals(50, market.checkout("B"));
	}

	@Test
	public void testC() {
		Assert.assertEquals(30, market.checkout("C"));
	}

	@Test
	public void testD() {
		Assert.assertEquals(0, market.checkout("D"));
	}

	
	@Test
	public void testEmptyCart() {
		Assert.assertEquals(0, market.checkout(""));
	}

	@Test
	public void testNullCart() {
		Assert.assertEquals(0, market.checkout(null));
	}

	@Test
	public void testInvalidCart() {
		Assert.assertEquals(0, market.checkout("1@!%2"));
	}

	@Test
	public void testMixedCart() {
		Assert.assertEquals(100, market.checkout("1@!BSCA%2"));
	}

}
