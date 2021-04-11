package com.ss.weekone.dayfive.ClassAssignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class BasicLambda {
	
	static BasicLambdaInterface sortStringAsc = (s) -> {
		String[] strArr = null;
		 
		strArr = s.split("\\.");	
		Arrays.sort(strArr, (a,b)->a.length() - b.length());
		List<String> lst = Arrays.asList(strArr);

		return lst;
	};
	
	static BasicLambdaInterface sortStringDesc = (s) -> {
		String[] strArr = null;
		 
		strArr = s.split("\\.");	
		Arrays.sort(strArr, (a,b)->b.length() - a.length());
		List<String> lst = Arrays.asList(strArr);

		return lst;
	};
	
	static BasicLambdaInterface sortStringAlphabetically = (s) -> {
		String[] strArr = null;
		 
		strArr = s.split("\\.");	
		String[] stringArr = null;
		stringArr = Stream.of(strArr).sorted().toArray(String[]::new);

		List<String> lst = Arrays.asList(stringArr);

		return lst;
	};
	
	static BasicLambdaInterface sortByE = (s) -> {
		String[] strArr = null;
		 
		strArr = s.split("\\.");	
		Arrays.sort(strArr, Comparator.comparing(x -> !x.startsWith("e")));
		List<String> lst = Arrays.asList(strArr);

		return lst;
	};
	
	static BasicLambdaInterface sortByEOwn = (s) -> {
		String[] strArr = null;
		 
		strArr = s.split("\\.");	
		Arrays.sort(strArr, Comparator.comparing(x -> !x.startsWith("e")));
		List<String> lst = Arrays.asList(strArr);

		return lst;
	};

	public static void main(String[] args) {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Please enter array of strings seperated by fullstop(dot)...");
			String s = read.readLine();
			//List<String> lst = sortStringByLength.sortByLength(s);
			List<String> lst = sortByE.sortByX(s);
			System.out.println("Sorted list in ascending order in length " + lst);
		
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}
		

	}

}
