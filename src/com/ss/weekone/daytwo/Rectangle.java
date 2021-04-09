package com.ss.weekone.daytwo;

/**
 * @author Charvin Patel
 */

public class Rectangle implements Shape {
	@Override
	public double calculateArea(double x, int y) {
		return x * y;
	}

	@Override
	public void display() {
		double width = 4;
		int length = 6;

		System.out.println("Area of Rectangle is " + calculateArea(width, length));

	}

}
