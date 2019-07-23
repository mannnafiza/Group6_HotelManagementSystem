package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.csis.Entities.Room;

class UnitTestRoom {
	Room room = new Room();

	@Test
	void testRoomType() {
		room.setRoomType("Regular Double");
		assertEquals("Regular Double", room.getRoomType());
	}
	
	@Test
	void testStayDuration() {
		room.setDuration(4);
		assertEquals(4, room.getDuration());
	}
	
	@Test
	void testisMeal() {
		room.setMeal("yes");
		assertEquals("yes", room.isMeal());
	}
	

}
