package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Entities.Staff;

class UnitTestStaff {
	
	Staff staff = new Staff();

	@Test
	void testCity() {
		staff.setCity("New West Minster");
		assertEquals("New West Minster", staff.getCity());
	}
	
	@Test
	void testGender() {
		staff.setGender("Male");
		assertEquals("Male", staff.getGender());
	}
	
	@Test
	void testName() {
		staff.setUsername("Nafiza");
		assertEquals("Nafiza", staff.getUsername());
	}
	

}
