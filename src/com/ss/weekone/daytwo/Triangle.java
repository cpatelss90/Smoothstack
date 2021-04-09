package com.ss.weekone.daytwo;

/**
 * @author Charvin Patel
 */

public class Triangle implements Shape {

	@Override
	public double calculateArea(double x, int y) {

		return (x * y) / 2;
	}

	@Override
	public void display() {

		double base = 4;
		int height = 6;

		System.out.println("Area of Triangle is " + calculateArea(base, height));

	}
}
