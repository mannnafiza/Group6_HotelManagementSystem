package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.csis.Entities.BillingData;

class UnitTestBillingData {

	BillingData bill = new BillingData();
	
	@Test
	void testIfRoomReserved() {
		bill.setRoomReserved(true);
		assertEquals(true, bill.isRoomReserved());
	}
	
	@Test
	void testDateHallReservedFor() {
		bill.setDateHallReservedFor(new Date());
		Date d = new Date();
		assertEquals(d, bill.getDateHallReservedFor());
	}
	
	@Test
	void testBillOwnerName() {
		bill.setName("Willy");
		assertEquals("Willy", bill.getName());
	}

	@Test
	void testNumOfGuests() {
		bill.setNumOfGuests(3);
		assertNotEquals(5, bill.getNumOfGuests());
	}
}
