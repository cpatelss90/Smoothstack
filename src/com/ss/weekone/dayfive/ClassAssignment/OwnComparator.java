package com.ss.weekone.dayfive.ClassAssignment;

import java.util.Comparator;

/**
 * @author Charvin Patel
 */

public class OwnComparator implements Comparator<String> {


	// Defined Own Comparator to be used in class BasicLambda
	@Override
	public int compare(String o1, String o2) {
		return o1.startsWith("e") ? -1 : 1;
	}

}
