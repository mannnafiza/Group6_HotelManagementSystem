package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Entities.Service;

class UnitTestRoomService {

	Service service = new Service();
	
	@Test
	void testUsername() {
		service.setCustomerName("aman");
		assertEquals("aman" , service.getCustomerName());
	}

	@Test
	void testResType() {
		service.setResType("room");
		assertEquals("room" , service.getResType());
	}
	
	@Test
	void testMealNeeded() {
		service.setMealNeeded("Yes");
		assertEquals("Yes" , service.getMealNeeded());
	}

	@Test
	void testHouseKeepingNeeded() {
		service.setHouseKeepingNeeded("Yes");
		assertEquals("Yes" , service.getHouseKeepingNeeded());
	}
	
	
	@Test
	void testMealType() {
		service.setMealType("Veg");
		assertEquals("Veg" , service.getMealType());
	}

	@Test
	void testTime() {
		service.setTime(12);
		assertEquals(12 , service.getTime());
	}
}
