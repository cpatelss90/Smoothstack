package com.ss.weekone.daythree;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Charvin Patel
 */

public class DThreeAssignmentOne {

	// This functions recursively find all the files in a given path
	public static void listFiles(File path, List<File> filePaths) {

		for (File s : path.listFiles()) {
			if (s.isFile()) {
				filePaths.add(s);
			}
			if (s.isDirectory()) {
				listFiles(new File(s.getAbsolutePath()), filePaths);
			}
		}
	}

	// This function takes user input for a path and
	// calls the listFiles() to lists all the files
	// in a path
	public static void main(String[] args) {
		boolean validPath = true;

		do {
			try {
				BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Please list a valid path: ");
				String filePath = read.readLine();

				File file = new File(filePath);
				List<File> pList = new ArrayList<>();

				listFiles(file, pList);

				for (File s : pList) {
					System.out.println(s.getCanonicalPath());
				}
				validPath = true;
			} catch (Exception e) {
				System.out.println("exception: " + e + "\n");
				validPath = false;
			}
		} while (!validPath);
	}
}
