package com.ss.weekone.dayfive.ClassAssignment;

import java.util.Comparator;

public class OwnComparator implements Comparator<String> {


	@Override
	public int compare(String o1, String o2) {
		return o1.startsWith("e") ? -1 : 1;
	}

}
