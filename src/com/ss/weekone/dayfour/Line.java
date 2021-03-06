package com.ss.weekone.dayfour;

/**
 * @author Charvin Patel
 */




// Line class provided by Trainer to test it
public class Line {

	private double x0;
	private double y0;
	private double x1;
	private double y1;

	public Line(double x0, double y0, double x1, double y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
	}

	// calculate the slope of the line
	public double getSlope() {
		// avoid dividing by zero
		if (x1 == x0) {
			throw new ArithmeticException();
		}

		return (y1 - y0) / (x1 - x0);

	}

	// calculate the distance of the line
	public double getDistance() {
		return Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
	}

	// if the difference between the slopes is very small, consider them parallel
	public boolean parallelTo(Line l) {
		if (Math.abs(getSlope() - l.getSlope()) < 0.0001) {
			return true;
		} else {
			return false;
		}
	}

}
