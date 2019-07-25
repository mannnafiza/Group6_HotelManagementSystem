package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.csis.Entities.Transaction;

class UnitTestTransaction {

	Transaction t = new Transaction();
	
	@Test
	void testPaymentMode() {
		t.setPaymentMode("Cash");
		assertEquals("Cash", t.getPaymentMode());
	}
	
	@Test
	void testCardNumber() {
		t.setCardNumber(12345678);
		assertNotEquals(123, t.getCardNumber());
	}
	
	@Test
	void testExpiryDate() {
		t.setExpiryDate("12/20");
		assertEquals("12/20", t.getExpiryDate());
	}

}
