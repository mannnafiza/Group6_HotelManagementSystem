package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Entities.OrderNewInventory;

class UnitTestOrderNewInventory {

	OrderNewInventory ordernewinventory = new OrderNewInventory();
	
	
	@Test
	void testItem() {
		ordernewinventory.setItem("food");
		assertEquals("food" , ordernewinventory.getItem());
	}
	
	
	@Test
	void testUnitPrice() {
		ordernewinventory.setUnitPrice(12);
		assertEquals(12 , ordernewinventory.getUnitPrice());
	}
	
	
	
	@Test
	void testAmount() {
		ordernewinventory.setAmount(10);
		assertEquals(10 , ordernewinventory.getAmount());
	}
	
	
	
}
