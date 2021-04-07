package com.ss.weekone.daytwo;

/**
 * @author charvin
 */


// Takes arguments from command line and adds all the numbers
// If variable num is not an int then a exception is thrown and caught
public class DTwoAssignmentOne {

    public static void main(String[] args) {

        int total = 0;

        for (String arg : args) {
            try {
                int num = Integer.parseInt(arg);
                total = num + total;
            } catch (NumberFormatException e) {
                System.out.println("Exception caught " + e);
            }
        }
        System.out.println("Total: " + total);
    }
}
