package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Entities.Banquet;

class UnitTestBanquet {

	Banquet banquet = new Banquet();
	
	@Test
	void testAdditionalService() {
		banquet.setAddService(true);
		assertEquals(true, banquet.isAddService());
	}
	
	@Test
	void test() {
		banquet.setMeal("veg");
		assertEquals("veg", banquet.isMeal());
	}

}
