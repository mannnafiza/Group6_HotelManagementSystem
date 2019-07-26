package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Entities.AddProperty;

class UnitTestInventory {

	AddProperty addproperty = new AddProperty();
	
	@Test
	void testItem() {
		addproperty.setItem("food");
		assertEquals("food" , addproperty.getItem());
	}

	@Test
	void testType() {
		addproperty.setType("Sea Food");
		assertEquals("Sea Food" , addproperty.getType());
	}
	
	/*@Test
	void testQuantity() {
		addproperty.setQuantity(1);
		assertEquals(1 , addproperty.getQuantity());
	}*/

	@Test
	void testPrice() {
		addproperty.setPrice(12);
		assertEquals(12 , addproperty.getPrice());
	}
	
	
	@Test
	void testCategory() {
		addproperty.setCategory("Veg");
		assertEquals("Veg" , addproperty.getCategory());
	}

	@Test
	void testUnitPrice() {
		addproperty.setUnitprice(4);
		assertEquals(4 , addproperty.getUnitprice());
	}
	
}

