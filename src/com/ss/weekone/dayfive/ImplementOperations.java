package com.ss.weekone.dayfive;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Charvin Patel
 */

// all the functionality of the operation is defined in this class
public class ImplementOperations {

	// helper method to test interface method operationX
	public boolean check(PerformOperationInterface op, int val) {
		return op.operationX(val);
	}

	// even/odd method as lambda function
	PerformOperationInterface isOdd(){
		return ans ->  ans % 2 == 0 ? true : false;
	};

	// prime/composite method as lambda function
	PerformOperationInterface isPrime(){

		return ans -> {
			if(ans <= 1) {
				return false;
			}
			for(int i = 2; i < ans; i++) {
				if(ans % i == 0) {
					return false;
				}
				else {
					return true;
				}
			}
			return true;
		};

	};


	// isPalindrome or not method as lambda function
	PerformOperationInterface isPalindrome(){
		return ans -> {
			String s = Integer.toString(ans);
			List<Integer> l1 = new ArrayList<>();
			List<Integer> l2 = new ArrayList<>();

			for(int x = 0; x < s.length(); x++) {
				int num = Character.getNumericValue(s.charAt(x));  
				l1.add(num);
			}
			for(int y = s.length()-1; y >= 0; y--) {
				int num = Character.getNumericValue(s.charAt(y));  
				l2.add(num);
			}
			if(l2.equals(l1)) {
				return true;
			}
			else {
				return false;
			}

		};
	};

}
