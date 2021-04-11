package com.weekone.testcase.dayfive;

/**
 * @author Charvin Patel
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.ss.weekone.dayfive.SingletonSample;


//Test File for testing class SingletonSampleTest
class SingletonSampleTest {
	@Test
	void testGetInstance() {
		assertNotNull(SingletonSample.getInstance());
		assertEquals("Singleton",SingletonSample.getInstance().getClass().getSimpleName());
	}


}
