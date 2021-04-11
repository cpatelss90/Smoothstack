package com.weekone.testcase.dayfive;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;

import com.ss.weekone.dayfive.RightMostDigitMain;
import com.ss.weekone.dayfive.RightmostDigitInterface;


//Test File for testing class RemoveXMainTest
class RightMostDigitMainTest {
	RightmostDigitInterface i;
	

	// Tests if the method returns the rightmosts digit of every number in a list
	@Test
	void testRightMostDigit() {
		RightMostDigitMain obj = new RightMostDigitMain();
		
		List<Integer> expected = new ArrayList<>();
		expected.add(2);
		expected.add(4);
		List<String> actual = Arrays.asList("112","234"); // pass this in our method RightMost()
		assertEquals(expected, obj.testRightMost(actual.toString()));
		
		expected.removeAll(expected); // remove all elements before testing again
		
		expected.add(5);
		expected.add(8);
		expected.add(3);
		actual = Arrays.asList("875","4398","53");
		assertEquals(expected, obj.testRightMost(actual.toString()));
		
		expected.removeAll(expected); // remove all elements before testing again
		
		actual = Arrays.asList("");
		assertEquals(expected, obj.testRightMost(actual.toString()));  // test for empty output	
		
		
	}

}
