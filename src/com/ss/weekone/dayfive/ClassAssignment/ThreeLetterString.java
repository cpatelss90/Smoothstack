package com.ss.weekone.dayfive.ClassAssignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Charvin Patel
 */

// Main class which implements the lambda function
public class ThreeLetterString {
	
	// for testing purpose only since junit dont allow to test lambda function
			public List<String> testThreeLetterString(String s){
				return threeLetter.threeLetterString(s);
			}
			

	// lambda function to return a 3 letter string and string starts with 'a'
	static ThreeLetterStringInterface threeLetter = (s) -> {

		String[] strArr = null;
		strArr = s.split(",");	

		List<String> lst = Stream.of(strArr).filter(x -> x.startsWith("a")).filter(x -> x.length() == 3).collect(Collectors.toList());
		return lst;
	};

	public static void main(String[] args) {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> lst = new ArrayList<>();
		try {
			System.out.println("Please enter array of Strings seperated by comma and No Space in between...");
			String s = read.readLine();
			lst = threeLetter.threeLetterString(s);
			System.out.println("Ans: " + lst);

		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}


	}

}

