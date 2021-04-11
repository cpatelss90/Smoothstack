package com.ss.weekone.dayfive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Charvin Patel
 */


// Main class to test if the method removes 'x' in each string in a list
public class RemoveXMain {
	
	// for testing purpose only since junit dont allow to test lambda function
	public List<String> testRemoveX(String s){
		return remove.removeX(s);
	}
	
	// lambda function to remove any 'x' in a list
	static RemoveXInterface remove = (s) -> {
		List<String> stringList = new ArrayList<>();

		stringList.add(s);
		List<String> lst = stringList.stream().map(n -> n.replaceAll("x","")).collect(Collectors.toList()); 	
		return lst;	
	};

	public static void main(String[] args) {
	
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = read.readLine();
			List<String> lst = remove.removeX(s);
			System.out.println("X removed: " + lst);
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}
		

	}

}
