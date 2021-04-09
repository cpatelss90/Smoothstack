package com.weekone.testcase.dayfour;

/**
 * @author Charvin Patel
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.ss.weekone.dayfour.Singleton;


class SingletonTest {

	@Test
	void testGetInstance() {
		assertNotNull(Singleton.getInstance());
		assertEquals("Singleton",Singleton.getInstance().getClass().getSimpleName());
	}


}
