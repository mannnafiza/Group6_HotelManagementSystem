package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
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
		Date d = new Date();
		bill.setDateHallReservedFor(d.toString());		
		assertEquals(d.toString(), bill.getDateHallReservedFor());
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
