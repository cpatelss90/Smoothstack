package com.weekone.testcase.dayfive;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.ss.weekone.dayfive.MultiplyByTwoInterface;
import com.ss.weekone.dayfive.MultiplyByTwoMain;


// Test File for testing class MultiplyByTwoMainTest
class MultiplyByTwoMainTest {
	MultiplyByTwoInterface i;


	// Tests if the method returns the int list where each int is multiplied by 2
	@Test
	void testRightMostDigit() {
		MultiplyByTwoMain obj = new MultiplyByTwoMain();
		
		List<Integer> expected = new ArrayList<>();
		expected.add(4);
		expected.add(8);
		List<String> actual = Arrays.asList("2","4"); // pass this in our method multiply()
		assertEquals(expected, obj.testMultiply(actual.toString()));

		expected.removeAll(expected); // remove all elements before testing again

		expected.add(16);
		expected.add(20);
		expected.add(30);
		actual = Arrays.asList("8","10","15");
		assertEquals(expected, obj.testMultiply(actual.toString()));

		expected.removeAll(expected); // remove all elements before testing again

		actual = Arrays.asList("");
		assertEquals(expected, obj.testMultiply(actual.toString()));  // test for empty output	
	}

}

