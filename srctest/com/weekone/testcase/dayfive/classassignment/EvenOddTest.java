package com.weekone.testcase.dayfive.classassignment;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import com.ss.weekone.dayfive.ClassAssignment.EvenOdd;

class EvenOddTest {

	@Test
	void testEvenOdd() {	
		EvenOdd obj = new EvenOdd();
		String actual = obj.testEvenOdd("44,55,198,877").toString();
		assertEquals(Arrays.asList("e44, e198, o55, o877").toString(),actual);
		
		
		String actualTwo = obj.testEvenOdd("9377,2448,1024,5877").toString();
		assertEquals(Arrays.asList("e2448, e1024, o9377, o5877").toString(),actualTwo);
		
		
	}

}
