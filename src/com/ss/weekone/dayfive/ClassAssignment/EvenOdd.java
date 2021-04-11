package com.ss.weekone.dayfive.ClassAssignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvenOdd {
	
	
	static EvenOddInterface evenOdd = (s) -> {
		
		String[] strArr = null;
		 
		strArr = s.split(",");	
		int[] intArr = new int[strArr.length];
		
	    for(int i = 0; i < strArr.length; i++) {
	    	intArr[i] = Integer.parseInt(strArr[i]);
	      }
	    
	    // converting array of ints to list of Integer
	     List<Integer> list = Arrays.stream(intArr)        // IntStream
                 .boxed()          // Stream<Integer>
                 .collect(Collectors.toList());
	     
	     
	     Stream<String> s1 = list.stream()
	    		    .filter(i -> i.intValue() % 2 == 0).map(x -> 'e' + x.toString());
	     
	     
	     Stream<String> s2 = list.stream()
	    		    .filter(i -> i % 2 != 0).map(x -> 'o' + x.toString());
	    
	    List<String> finalList = Stream.concat(s1, s2).collect(Collectors.toList());

		return finalList;
		
	};
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> lst = new ArrayList<>();
		try {
			System.out.println("Please enter array of ints seperated by comma...");
			String s = read.readLine();
		    lst = evenOdd.evenOdd(s);
		    System.out.println("Ans: " + lst);
		
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}
		

	}

}
