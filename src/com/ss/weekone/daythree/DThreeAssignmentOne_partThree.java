package com.ss.weekone.daythree;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Charvin Patel
 */

public class DThreeAssignmentOne_partThree {

	// This functions returns the count of a particular
	// character specified by a command line
	public static void characterCount(String[] args) {
		FileInputStream fileIn = null;
		Scanner scan = null;
		String s = Arrays.toString(args);

		if (s.length() < 4) {
			try {
				fileIn = new FileInputStream("resource/append.txt");
				int count = 0;
				char c = s.charAt(1);
				String str = "";
				scan = new Scanner(fileIn);

				while (scan.hasNextLine()) {
					str = scan.nextLine();
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) == c || str.charAt(i) == Character.toUpperCase(c)
								|| str.charAt(i) == Character.toLowerCase(c)) {
							count++;
						}
					}
				}
				System.out.println("\n" + "Total num of " + "'" + c + "'" + " occurs in a file: " + count);

			} catch (Exception e) {
				System.out.println("Exception: " + e);
			} finally {
				if (scan != null) {
					scan.close();
				}
			}
		} else {
			System.out.println("\n" + "Please re run the program by inputting a particular character in command line.");
		}
	}

	// Main calls characterCount() function
	public static void main(String[] args) {
		characterCount(args);
	}
}
