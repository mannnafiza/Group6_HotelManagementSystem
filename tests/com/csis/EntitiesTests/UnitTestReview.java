package com.csis.EntitiesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis.Entities.Review;

class UnitTestReview {

	Review  review = new Review ();
	
	
	@Test
	void testComment() {
		
		review.setComment("I am tester");
		assertEquals("I am tester", review.getComment());
	}

}
