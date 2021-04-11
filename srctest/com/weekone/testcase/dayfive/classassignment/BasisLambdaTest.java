package com.weekone.testcase.dayfive.classassignment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.ss.weekone.dayfive.ClassAssignment.BasicLambda;
import com.ss.weekone.dayfive.ClassAssignment.BasicLambdaInterface;


class BasisLambdaTest {

	BasicLambdaInterface i;

	
	@Test
	void testSortByAlphabatically() {
		BasicLambda obj = new BasicLambda();
		String actual = obj.testAlphabatically("before that, This. a is").toString();
		assertEquals(Arrays.asList(" a is, before that, This").toString(), actual);	
	}
	
	@Test
	void testSortByEOwn() {
		BasicLambda obj = new BasicLambda();
		List<String> expected = new ArrayList<>();
		expected.add(List.of("This","Who are","Who are this and","This is what needed").toString());
		
		List<String> actual = Arrays.asList("This","Who are","Who are this and", "This is what needed"); // pass this in our method RightMost()
		assertEquals(expected, obj.testSortEOwn(actual.toString()));
		
	}	
	

}


