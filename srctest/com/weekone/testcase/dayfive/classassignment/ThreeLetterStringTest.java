package com.weekone.testcase.dayfive.classassignment;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import com.ss.weekone.dayfive.ClassAssignment.ThreeLetterString;

class ThreeLetterStringTest {

	@Test
	void testThreeLetterString() {	
		ThreeLetterString obj = new ThreeLetterString();
		String actual = obj.testThreeLetterString("ddsfg,aed,gfg,aefgh,gfyhf,adf,hffh,sefse,awq").toString();
		assertEquals(Arrays.asList("aed, adf, awq").toString(),actual);
		
		
		String actualTwo = obj.testThreeLetterString("agf,fdfg,gghhtrh,awqed,ffdgfg,tyr,ahr,dffsdf").toString();
		assertEquals(Arrays.asList("agf, ahr").toString(),actualTwo);	
		
	}

}
