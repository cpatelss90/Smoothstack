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

// Main class for testing if the method returns the list where each int is multiplied by two
public class MultiplyByTwoMain {
	
	// for testing purpose since jnit dont allow to test lambda function
	public List<Integer> testMultiply(String s){
		return multiply.multiplyByTwo(s);
	}
	
	
	// lambda function which multiplies each int in a list by 2
	static MultiplyByTwoInterface multiply = (s) -> {
		
		List<String> stringList = new ArrayList<>();
		List<Integer> intList = new ArrayList<>();

		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(s); 

		while (m.find()) {
			stringList.add(m.group());
		}

		intList  = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> lst = intList.stream().map(n -> n * 2).collect(Collectors.toList());

		return lst;
		
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = read.readLine();
			List<Integer> lst = multiply.multiplyByTwo(s);
			System.out.println("All number multiplied by two: " + lst);
		} catch (IOException e) {
			System.out.println("Excpetion: " + e);
			
		}
		

	}

}
