package com.ss.weekone.dayfive;


/**
 * @author Charvin Patel
 */

public class Recursion {



	public static boolean groupSumClump(int start, int[] nums, int target) {

		// if length of array is 0 then return
		if(nums.length == 0) {
			return target ==0;
		}
		
		
		int strt = 0;
		int sameNumSequence = nums[strt];  
		
		// This for loop checks if we have any same number in adjacent,
		// and if we do have then just sums all same number in a adjacent and
		// replace all other index of the numbers to 0
		
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == sameNumSequence) { // checks if previous element is same as next element
				nums[strt] = nums[i] + nums[strt];  // assigns the 1st index of sequence to all same numbers
				nums[i] = 0;     				// finally sets all other same num indexes to 0
			} else {
				strt = i;						// increments strt from 0 to 1...+1
				sameNumSequence = nums[i];     // sets current index value to SameNumSequence
			}
		}

		
		
		if (start >= nums.length) {
			return target == 0; // if starting point index is greater then arr length
		}						// then just returns true if target == 0
													

		if (groupSumClump(start+1, nums, target-nums[start])) {  // recursively calls this method each time
			return true;										// incrementing start and subtracting 
		}														// target as we keep adding curr index values

		if (groupSumClump(start+1, nums, target)) {   // recursively calls this method each time
			return true;							 // incrementing start
		}

		else {
			return false; 
		}

	}

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,2,4,1}; 
		System.out.println(groupSumClump(0,arr,10));

	}

}
