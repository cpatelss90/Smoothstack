package com.ss.weekone.dayfive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Charvin Patel
 */

// Main class for testing Operation as odd/even, prime/composite, palindrome or not
public class OperationMain {

	// This method first calls isOdd() method and then passing that method 
	// as value to helper method check() which then calls interface method OperationX
	public static void operation(String s){
		PerformOperationInterface i;
		LinkedList<String> numbers = new LinkedList<String>();
		ImplementOperations impOp = new ImplementOperations();


		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s); 
		while (m.find()) {
			numbers.add(m.group());

		}

		try {
		int num = Integer.parseInt(numbers.get(1));

		switch(s.charAt(0)) {
		case '1':
			i = impOp.isOdd();
			boolean odd = impOp.check(i, num);
			if(odd){
				System.out.println("EVEN");	
			}
			else {
				System.out.println("ODD");
			}
			break;

		case '2':
			i = impOp.isPrime();
			boolean prime = impOp.check(i, num);
			if(prime == true) {
				System.out.println("PRIME");
			}
			else {
				System.out.println("COMPOSITE");
			}
			break;

		case '3':
			i = impOp.isPalindrome();
			boolean palin = impOp.check(i, num);
			if(palin == true) {
				System.out.println("PALINDROME");
			}
			else {
				System.out.println("NOT PALIMDRONE");
			}
		}
		} 
		catch(Exception e) {
			System.out.println("Exception: " + e);
			System.out.println("Please enter a valid input again.. " );
			String args[] = null;
			OperationMain.main(args);
		}

	}

	public static void main(String[] args) {	
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please specify operation num & num to check for: ");
		
		boolean validInput = true;

		do {
		try {
			String s = read.readLine();
			operation(s);
		} catch (IOException e) {
			System.out.println("Exception: " + e);
			System.out.println("Please enter a valid input again.. " );
			validInput = false;
			
		}
		}while(!validInput);

	}

}


