package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Entities.UserInfo;

class UnitTestUserInfo {

	UserInfo user = new UserInfo();
	
	@Test
	void test_SetUserId() {
		user.setId(1);
		
		assertEquals(1, user.getId());
		
	}
	
	@Test
	void test_SetUserName() {
		user.setUsername("Maria");
		
		assertEquals("Maria", user.getUsername());
		
	}

}
