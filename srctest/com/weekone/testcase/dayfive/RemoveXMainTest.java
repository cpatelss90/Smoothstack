package com.weekone.testcase.dayfive;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.ss.weekone.dayfive.RemoveXInterface;
import com.ss.weekone.dayfive.RemoveXMain;


//Test File for testing class RemoveXMainTest
class RemoveXMainTest {

		RemoveXInterface i;

		// Tests if the method removes 'x' from the list
		@Test
		void testRemoveX() {
			RemoveXMain obj = new RemoveXMain();
			
			List<String> expected = new ArrayList<>();
			
			expected.add(List.of("sss","f").toString());
			List<String> actual = Arrays.asList("sxxss","xxfxx"); // pass this in our method removeX()
			assertEquals(expected, obj.testRemoveX(actual.toString()));

			expected.removeAll(expected); // remove all elements before testing again

			expected.add(List.of("dfd","bbb","asdf").toString());
			actual = Arrays.asList("xxdfxdxx","xbbbx","asdf");
			assertEquals(expected, obj.testRemoveX(actual.toString()));

			expected.removeAll(expected); // remove all elements before testing again

			expected.add(List.of("").toString());
			actual = Arrays.asList("");
			assertEquals(expected, obj.testRemoveX(actual.toString()));  // test for empty output	
		}

	}


