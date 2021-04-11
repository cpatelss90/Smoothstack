

package com.ss.weekone.dayfive.ClassAssignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ThreeLetterString {

	static ThreeLetterStringInterface threeLetter = (s) -> {

		String[] strArr = null;
		strArr = s.split(",");	

		List<String> lst = Stream.of(strArr).filter(x -> x.startsWith("a")).filter(x -> x.length() == 3).collect(Collectors.toList());
		return lst;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		List<String> lst = new ArrayList<>();
		try {
			System.out.println("Please enter array of Strings seperated by comma...");
			String s = read.readLine();
			lst = threeLetter.threeLetterString(s);
			System.out.println("Ans: " + lst);

		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}


	}

}

