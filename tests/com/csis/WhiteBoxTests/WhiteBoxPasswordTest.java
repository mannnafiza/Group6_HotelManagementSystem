package com.csis.WhiteBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Boundary.Home;
import com.csis.Entities.UserInfo;

class WhiteBoxPasswordTest {

	
	@Test
	void testPasswordHashing() {
		
		String encryptedPass = Home.encrypt("password");
		
		assertEquals("password", Home.decrypt(encryptedPass));
	}
	
}
