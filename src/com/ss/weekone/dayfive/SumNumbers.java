package com.ss.weekone.dayfive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Charvin Patel
 */

public class SumNumbers {

	public static boolean sum(int start, int[] arr, int target) {


		//System.out.println("target: " + target);

		//else {
		List<Integer> myLst = new ArrayList<>();
		// 1 2 3
		for(int i = 0; i < arr.length; i++) {

			int summ = target;    // 6

			int index = myLst.size() - 1;

			if(summ == 0) {
				return true;
			}

			if(summ > target){
					myLst.remove(index);
					sum(start+1,arr, target);
			}

			myLst.add(arr[i]);

			summ = summ - myLst.get(i);


			/*for (int number : myLst) {
				    summ += number;
				}*/

			sum(start,arr, target-arr[i]);
		}
		System.out.println("myLst" + myLst);
		//System.out.println("sum: " + summ);
		//}

		return false;
	}

	/*public static boolean groupSumClump(int start, int[] nums, int target)
	{
		if(start >= nums.length)
		{
			if(target == 0)
				return true;
			return false;
		}
		int i = start + 1;
		for(;  i < nums.length && nums[start] == nums[i]; i++);
		if(groupSumClump(i, nums, target - ((i - start) * nums[start])))
			return true;
		return groupSumClump(i, nums, target);	
	}*/


	public static void main(String[] args) {

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		try {
			//s = read.readLine();

			String[] intsInString = read.readLine().split(" ");
			List<Integer> ii = new ArrayList<>();

			int[] arr = new int[intsInString.length];
			int start = 0;

			for(int i=0;i<intsInString.length;i++)
			{
				arr[i]=Integer.parseInt(intsInString[i]);
			}

			/*for(int i = 0; i < arr.length-1; i++) {

				if(arr[i] == arr[i+1]) {
					System.out.println("same seq: " + arr[i]);
					if(arr.length > 1) {
					if(arr[i+1] == arr[i-1]) {
						ii.add(arr[i+1]);
					}
					}

					ii.add(arr[i]);
					//ii.add(arr[i+1]);

				}
			}*/


			System.out.println(sum(start,arr,6));
			//System.out.println(groupSumClump(0,arr,14));
		} catch (IOException e) {

			System.out.println("Exception: " + e);
		}


	}

}
