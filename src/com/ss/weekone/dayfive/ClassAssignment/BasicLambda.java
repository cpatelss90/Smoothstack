package com.ss.weekone.dayfive.ClassAssignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Charvin Patel
 */



// Main class which has lambda functions to sort array of string
// by Ascending, descending, alphabetically, and strings starting with 'e'
public class BasicLambda {


	// for testing purpose only since junit dont allow to test lambda function
	public List<String> testAscending(String s){
		return sortStringAsc.sortByX(s);
	}

	// for testing purpose only since junit dont allow to test lambda function
	public List<String> testDescending(String s){
		return sortStringDesc.sortByX(s);
	}

	// for testing purpose only since junit dont allow to test lambda function
	public List<String> testAlphabatically(String s){
		return sortStringAlphabetically.sortByX(s);
	}

	// for testing purpose only since junit dont allow to test lambda function
	public List<String> testSortE(String s){
		return sortByE.sortByX(s);
	}

	// for testing purpose only since junit dont allow to test lambda function
	public List<String> testSortEOwn(String s){
		return sortByEOwn.sortByX(s);
	}


	// lambda function to sort list of string in ascending order by length
	static BasicLambdaInterface sortStringAsc = (s) -> {
		String[] strArr = null;	 
		strArr = s.split("\\.");	 
		Arrays.sort(strArr, (a,b)->a.length() - b.length()); 
		List<String> lst = Arrays.asList(strArr);
		return lst;
	};


	// lambda function to sort list of string in descending order by length
	static BasicLambdaInterface sortStringDesc = (s) -> {
		String[] strArr = null;

		strArr = s.split("\\.");	
		Arrays.sort(strArr, (a,b)->b.length() - a.length());
		List<String> lst = Arrays.asList(strArr);

		return lst;
	};


	// lambda function to sort list of string alphabetically
	static BasicLambdaInterface sortStringAlphabetically = (s) -> {
		String[] strArr = null;

		strArr = s.split("\\.");	
		String[] stringArr = null;
		stringArr = Stream.of(strArr).sorted().toArray(String[]::new);

		List<String> lst = Arrays.asList(stringArr);

		return lst;
	};

	// lambda function to sort list of string starting with 'e' first
	static BasicLambdaInterface sortByE = (s) -> {
		String[] strArr = null;

		strArr = s.split("\\.");	
		Arrays.sort(strArr, Comparator.comparing(x -> !x.startsWith("e")));

		List<String> lst = Arrays.asList(strArr);

		return lst;
	};

	// lambda function to sort list of string starting with 'e' first( using own method)
	static BasicLambdaInterface sortByEOwn = (s) -> {
		String[] strArr = null;

		strArr = s.split("\\.");	
		Arrays.sort(strArr, new OwnComparator());

		List<String> lst = Arrays.asList(strArr);

		return lst;
	};


	public static void main(String[] args) {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> lst = new ArrayList<>();
		try {
			System.out.println("Please enter array of strings seperated by fullstop(dot)...");
			String s = read.readLine();

			// call each method as you like(one at a time)
			lst = sortStringAsc.sortByX(s);
			//lst = sortStringDesc.sortByX(s);
			//lst = sortStringAlphabetically.sortByX(s);
			//lst = sortByE.sortByX(s);
			//lst = sortByEOwn.sortByX(s);
			System.out.println("Sorted list: " + lst);

		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}


	}

}
