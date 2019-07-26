package com.csis.ControllerTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Controller.BillCalculatorDAO;
import com.csis.Entities.BillingData;

class IntegrationTestEmployeeDiscount {

	BillCalculatorDAO billCalculatorDAO = new BillCalculatorDAO();
	BillingData bill = new BillingData();
	
	@Test
	void test_DiscountGivenIfStaffMember() {
		
		if(billCalculatorDAO.isAStaffMemeber("Evylene"))
		{
			bill.setDiscount(10.00f);
		}else
			bill.setDiscount(0.00f);
		
		assertEquals(10.00f, bill.getDiscount());
	}

	@Test
	void test_NoDiscountForNonStaffMember() {
		
		if(billCalculatorDAO.isAStaffMemeber("Sarah"))
		{
			bill.setDiscount(10.00f);
		}else
			bill.setDiscount(0.00f);
		
		assertNotEquals(10.00f, bill.getDiscount());
	}
}
