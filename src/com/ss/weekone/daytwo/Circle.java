package com.ss.weekone.daytwo;

/**
 * @author Charvin Patel
 */

public class Circle implements Shape {

    @Override
    public double calculateArea(double x, int y) {
        return x*y;
    }

    @Override
    public void display() {
        double pi = 3.14;
        int rSquared = 36;

        System.out.println("Area of Circle is " + calculateArea(pi,rSquared));
    }

}

