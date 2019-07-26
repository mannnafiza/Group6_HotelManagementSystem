package com.csis.SystemTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;

import java.text.DateFormat;

import org.junit.jupiter.api.Test;

import com.csis.Boundary.CustomerBill;
import com.csis.Boundary.DBHelper;
import com.csis.Boundary.Payment;
import com.csis.Boundary.PaymentReceipt;
import com.csis.Boundary.Registration;
import com.csis.Boundary.Reservation;
import com.csis.Controller.Authenticate;
import com.csis.Controller.BillCalculatorDAO;
import com.csis.Controller.MeetingReservationDAO;
import com.csis.Controller.PaymentDAO;
import com.csis.Controller.Validate;
import com.csis.Entities.BillingData;
import com.csis.Entities.Meeting;
import com.csis.Entities.Transaction;
import com.csis.Entities.UserInfo;


class UserModuleTest {

	static UserInfo user = new UserInfo();
	Authenticate auth = new Authenticate();
	static int loginId;
	static int id;
	Meeting meet = new Meeting();
	ArrayList<Meeting> listMeetings = new ArrayList<>();
	//MeetingReservationDAO meeting = new MeetingReservationDAO(UserModuleTest.user);
	DBHelper db = new DBHelper();
	BillCalculatorDAO billCalculatorDAO = new BillCalculatorDAO();
	BillingData bill = new BillingData();
	Transaction t = new Transaction();	

	
//	@Test
//	void testUserLogin() {
//		user.setUsername("Nafiza");
//		
//		Validate validate = new Validate("Nafiza","Nafiza123");
//		auth.setUsername("Nafiza");
//		auth.setPassword("Nafiza123");
//		user.setId(db.getUserId("Nafiza"));
//		
//		System.out.println("Idddd:   " + user.getId() + "name: " +user.getUsername());
//		Reservation.main(null, user);
//		assertEquals("Nafiza", user.getUsername());
//		
//		
//	}
//	
	
//	@Test
//	void testMeetingReservation()
//	{
//		MeetingReservationDAO meeting = new MeetingReservationDAO(UserModuleTest.user);
//		meet.setDuration(2);
//		meet.setMeal("veg");
//		meet.setReservedate(null);
//		meeting.insertReservationInformation(UserModuleTest.user.getId(), UserModuleTest.user.getUsername(), "meeting","-", 0, meet.isMeal(),
//				"-", null, null, meet.getDuration(), false, 0, "-" );
//		
//		listMeetings = meeting.listMeetingData();
//		
//		assertEquals(0, listMeetings.get(listMeetings.size() - 1).getDuration());
//	}
	
	
	@Test
	void test_Reservation_Billing_Payment() {
		
		
		user.setUsername("Nafiza");
		
		Validate validate = new Validate("Nafiza","Nafiza123");

		auth.setUsername("Nafiza");
		auth.setPassword("Nafiza123");
		user.setId(db.getUserId("Nafiza"));
		
		System.out.println("Idddd:   " + user.getId() + "name: " +user.getUsername());
		Reservation.main(null, user);
		
		//assert Test for Reservation.java
		assertEquals("Nafiza", user.getUsername());
		
		MeetingReservationDAO meeting = new MeetingReservationDAO(UserModuleTest.user);
		meet.setDuration(2);
		meet.setMeal("veg");
		
		java.sql.Date sqlDate = new java.sql.Date(00, 00, 00);
		meet.setReservedate(sqlDate);
		meeting.insertReservationInformation(user.getId(), user.getUsername(), "meeting","-", 0, meet.isMeal(),
				"-", sqlDate, null, meet.getDuration(), false, 0, "-" );
		
		listMeetings = meeting.listMeetingData();
		
		//assert Test for MeetingReservationDAO.java
		assertEquals(0, listMeetings.get(listMeetings.size() - 1).getDuration());
		
		
		billCalculatorDAO.calculate(UserModuleTest.user);
		ArrayList<String> list = billCalculatorDAO.getReservationData(UserModuleTest.user, "meeting");
		
		for(String s: list)
			System.out.println("Itembjhb: "+ s + "       ");
		
		//assert Test for billCalculatorDAO.java
		assertEquals("meeting", list.get(1));
		assertEquals("Nafiza", user.getUsername());
		
		
		bill.setName(user.getUsername());
		bill.setFinalAmount(154.66f);
		Date currentDate = new Date();
		String date = DateFormat.getDateInstance().format(currentDate);
		bill.setDate(date);
		String time = DateFormat.getTimeInstance().format(currentDate);
		bill.setTime(time);
		
		CustomerBill customerBill = new CustomerBill(bill, user);
		//CustomerBill.main(null, bill, user);
		customerBill.show(bill);
		billCalculatorDAO.addBillEntry(user, bill);
	
		//assert Test for CustomerBill.java
		assertEquals("Bill for Nafiza", customerBill.lblBillFor.getText());
		
		customerBill.btnPayBill.setSelected(true);
		System.out.println("Val:  "+ bill.getFinalAmount());
		if(customerBill.btnPayBill.isSelected())
		{
			
			//Payment.main(null, bill, user);
			Payment payment = new Payment(bill, user);
			
			payment.btnPay.setSelected(true);
			
			
			t.setUserId(bill.getUserId());
			t.setUserName(bill.getName());
			t.setAmountPaid(bill.getFinalAmount());
			
			payment.rdbtnCash.setSelected(true);
			if(payment.rdbtnCash.isSelected()) {
	        	payment.modeOfPayment = "Cash";
		      }else if(payment.rdbtnCard.isSelected()) {
		    	  payment.modeOfPayment = "Card";
		      }
			t.setPaymentMode(payment.modeOfPayment);
		
			System.out.println("Mode Chosen: "+ payment.modeOfPayment);
			
			//assert Test for Payment.java
			assertEquals("Cash", payment.modeOfPayment);
		}
		PaymentDAO paymentDAO = new PaymentDAO();
		paymentDAO.addtransactionEntry(t);
		PaymentReceipt.main(null,t, user);
		PaymentReceipt paymentReceipt = new PaymentReceipt(t, user);
		
		System.out.print("Mode On Receipt: "+ paymentReceipt.lblModeOfPayment.getText());
		
		//assert Test for PaymentReceipt.java
		assertEquals("Cash", paymentReceipt.lblModeOfPayment.getText());
		
		}
	}
	

	


