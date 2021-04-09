package com.weekone.testcase.dayfour;

/**
 * @author Charvin Patel
 */


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ss.weekone.dayfour.Line;

class LineTest {

	double x0;
	double y0;
	double x1;
	double y1;

	Line l;

	@BeforeEach
	public void setup() {
		x0 = 6;
		y0 = 4;
		x1 = 8;
		y1 = 8;

		l = new Line(x0, y0, x1, y1);
	}

	@Test
	void testGetSlope() {
		assertEquals(2, l.getSlope());
	}

	@Test
	void testGetDistance() {
		assertEquals(4.4721, l.getDistance(), 0.0001);
	}

	@Test
	void testParallelTo() {
		// l = new Line()
		assertEquals(true, l.parallelTo(l));
	}

}
