package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Entities.Meeting;

class UnitTestMeeting {

	Meeting meeting =  new Meeting();
	
	@Test
	void testMeetingDuration() {
		meeting.setDuration(2);
		assertEquals(2, meeting.getDuration());
	}
	
	@Test
	void testMealStatus() {
		meeting.setMeal("veg");
		assertEquals("veg", meeting.isMeal());
	}
	


}
