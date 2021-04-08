package com.ss.weekone.dayone;

/**
 * @author Charvin Patel
 */

public class DoneAssignmentOne_partTwo {


    public static void main(String[] args) {

        // Pattern 1:
        System.out.println("1) ");

        // gets 4 rows
        for (int row = 0; row < 4; row++) {

            // for column
            for (int col = 0; col <= row; col++) {

                // prints stars
                System.out.print("* ");
            }

            // gets a new line after each row
            System.out.println();
        }

        // Seperate for loop for 9 dots
        for (int i = 0; i < 9; i++) {
            System.out.print(". ");
        }

        System.out.println("\n");


        // Pattern 2:
        System.out.println("2) ");


        // Seperate for loop for 10 dots
        for (int i = 0; i < 10; i++) {

            System.out.print(". ");
        }

        // gets new line
        System.out.println();


        // gets 4 rows
        for (int row = 4; row >= 1; row--) {

            // for column
            for (int col = 0; col <= (row - 1); col++) {

                // prints stars
                System.out.print("* ");
            }

            // gets a new line after each row
            System.out.println();
        }

        System.out.println();


        // Pattern 3:
        System.out.println("3) ");

        // gets 4 rows
        for (int row = 0; row < 5; row++) {

            // prints spaces
            for (int space = (2 * (5 - row)); space > (-2); space--) {

                System.out.print(" ");
            }

            // prints stars
            for (int col = 0; col <= (2 * (row - 1)); col++) {
                System.out.print("* ");

            }
            System.out.println();

        }

        // Seperate for loop for 11 dots
        for (int x = 0; x < 11; x++) {

            System.out.print(". ");
        }
        System.out.println("\n");


        // Pattern 4:
        System.out.println("4) ");

        // Seperate for loop for 12 dots
        for (int x = 0; x < 12; x++) {

            System.out.print(". ");
        }

        System.out.println();


        int num = 5;

        // gets 4 row
        for (int row = 4; row >= 1; row--) {

            //prints spaces
            for (int space = (2 * (num - row)); space > (-2); space--) {

                System.out.print(" ");
            }

            // prints stars
            for (int col = 0; col <= (2 * (row - 1)); col++) {
                System.out.print("* ");

            }
            System.out.println();

        }


    }

}

