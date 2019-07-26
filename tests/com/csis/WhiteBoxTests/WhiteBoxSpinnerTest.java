package com.csis.WhiteBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JSpinner;

import org.junit.jupiter.api.Test;

import com.csis.Controller.MeetingReservationDAO;
import com.csis.Controller.RoomReservationDAO;
import com.csis.Entities.UserInfo;

class WhiteBoxSpinnerTest {

	UserInfo user = new UserInfo();
	JSpinner spinner = new JSpinner();
	String errorMsg = "";
	
	@Test
	void testA_SpinnerRoom() {
		user.setUsername("Nafiza");
		RoomReservationDAO reservation = new RoomReservationDAO(user);
		spinner.setValue(-2);
		reservation.setStayDuration(spinner);
		errorMsg = reservation.msg;
		assertEquals("Enter a valid stay duration", errorMsg);
	}
	
	
	@Test
	void testB_SpinnerMeeting() {
		user.setUsername("Nafiza");
		MeetingReservationDAO meeting  = new MeetingReservationDAO(user);
		spinner.setValue(0);
		meeting.setMeetingDuration(spinner);
		errorMsg = meeting.msg;
		assertEquals("Enter a valid meeting duration", errorMsg);
	}

}
