package com.weekone.testcase.dayfive;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ss.weekone.dayfive.Recursion;

class RecursionTest {

	@Test
	void testGroupSumClump() {
		
		int[] arr = new int[7];
		arr[0] = 7;
		arr[1] = 10;
		arr[2] = 10;
		arr[3] = 10;
		arr[4] = 5;
		arr[5] = 8;
		arr[6] = 5;
		
		
		assertFalse(Recursion.groupSumClump(0,arr, 3));
		assertTrue(Recursion.groupSumClump(0,arr, 5));
		assertTrue(Recursion.groupSumClump(0,arr, 15));
		assertTrue(Recursion.groupSumClump(0,arr, 7));
		assertTrue(Recursion.groupSumClump(0,arr, 8));
		assertFalse(Recursion.groupSumClump(0,arr,2));
		
		
		assertTrue(Recursion.groupSumClump(0,arr, 25));
		assertFalse(Recursion.groupSumClump(0,arr, 21));
		assertTrue(Recursion.groupSumClump(0,arr,43));
		assertTrue(Recursion.groupSumClump(0,arr, 40));
		assertTrue(Recursion.groupSumClump(0,arr, 35));
		assertFalse(Recursion.groupSumClump(0,arr,28));
		
		
	}

}
