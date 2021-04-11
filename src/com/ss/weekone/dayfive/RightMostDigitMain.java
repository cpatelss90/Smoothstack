package com.ss.weekone.dayfive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * @author Charvin Patel
 */


//Main class for testing if the method returns the right most digit
public class RightMostDigitMain {
	
	// For testing purpose only since we can;t call lambda func in Junit
	 public List<Integer> testRightMost(String s){
		 return rightmost.rightMostDigit(s);
	 }
	 
	 
	
	 // lambda function which returns the rightmost digit 
	static RightmostDigitInterface rightmost = (s) ->  {

		List<String> stringList = new ArrayList<>();
		List<Integer> intList = new ArrayList<>();
		

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s); 

		while (m.find()) {
			stringList.add(m.group());
		}

		intList  = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> lst = intList.stream().map(n -> n % 10).collect(Collectors.toList());
		return lst;
	};
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the list of each ints seperated by a single space..");
		boolean validInput = true;

		do {
		try {
			String s = read.readLine();	
			List<Integer> lst = rightmost.rightMostDigit(s);
			System.out.println("Rightmost digit of each number is: " + lst);
		}
		catch (IOException e) {
			System.out.println("Exception: " + e);
			System.out.println("Please enter a valid input again... ");
			validInput = false;
		}
		}while(!validInput);

	}

}
