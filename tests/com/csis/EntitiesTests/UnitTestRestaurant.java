package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Entities.Restaurant;

class UnitTestRestaurant {
	
	Restaurant restaurant = new Restaurant();

	@Test
	void testMealType() {
		restaurant.setMealType("non-veg");
		assertEquals("non-veg", restaurant.getMealType());
	}
	
	@Test
	void testNoOfGuests() {
		restaurant.setNoOfGuest(11);
		assertEquals(11, restaurant.getNoOfGuest());
	}
	
	@Test
	void testReservationFor() {
		restaurant.setReservationFor("Brunch");
		assertEquals("Brunch", restaurant.getReservationFor());
	}

}
