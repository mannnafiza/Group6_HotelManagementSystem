package com.csis.SystemTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.csis.Boundary.Reservation;
import com.csis.Controller.Authenticate;
import com.csis.Controller.MeetingReservationDAO;
import com.csis.Controller.Validate;
import com.csis.Entities.Meeting;
import com.csis.Entities.UserInfo;


class UserModuleTest {

	static UserInfo user = new UserInfo();
	Authenticate auth = new Authenticate();
	static int loginId;
	static int id;
	Meeting meet = new Meeting();
	ArrayList<Meeting> listMeetings = new ArrayList<>();
	
	@Test
	void testUserLogin() {
		user.setUsername("Nafiza");
		
		Validate validate = new Validate("Nafiza","Nafiza123");
		auth.setUsername("Nafiza");
		auth.setPassword("Nafiza123");
		loginId = user.getId();
		user.setId(loginId);
		
		
		Reservation.main(null, user);
		assertEquals("Nafiza", user.getUsername());
		
		
	}
	
	
	@Test
	void testMeetingReservation()
	{
		MeetingReservationDAO meeting = new MeetingReservationDAO(UserModuleTest.user);
		meet.setDuration(2);
		meet.setMeal("veg");
		meet.setReservedate(null);
		meeting.insertReservationInformation(UserModuleTest.user.getId(), UserModuleTest.user.getUsername(), "meeting","-", 0, meet.isMeal(),
				"-", null, null, meet.getDuration(), false, 0, "-" );
		
		
		listMeetings = meeting.listMeetingData();
		
		assertEquals(0, listMeetings.get(listMeetings.size() - 1).getDuration());
	}
	
	
	@Test
	void testBillCreation() {
		
		
	}
	
	
	@Test
	void testPayment() {
		
	}
	
	

}
