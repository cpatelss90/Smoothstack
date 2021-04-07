package com.ss.weekone.daytwo;

import java.util.Scanner;

public class DTwoAssignmentOne_partTwo {

    // Takes user input to decide how big is 2D Array
    // Then takes all the values from user to initialize the array

    public static void maxNumInArray(){
        Scanner sc = new Scanner(System.in);
        int[] rowCol = new int[2];

        System.out.println("Please enter number of rows: ");
        String rNum = sc.nextLine();

        System.out.println("Please enter number of cols: ");
        String cNum = sc.nextLine();

        int rowNum = Integer.parseInt(rNum);
        int colNum = Integer.parseInt(cNum);

        int[][] twoDArray = new int[rowNum][colNum];
        int maxNum = 0;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                System.out.println("Please enter number for row " + i + "," + " Col " + j);
                String userNum = sc.nextLine();
                int num = Integer.parseInt(userNum);
                twoDArray[i][j] = num;

                if (twoDArray[i][j] > maxNum) {
                    maxNum = twoDArray[i][j];
                    rowCol[0] = i;
                    rowCol[1] = j;
                }
            }
        }

        System.out.println("Max Number Row is " + rowCol[0] +
                "\n" + "Max Number Column is " + rowCol[1]);
        System.out.println("Max Number in array is: " + maxNum + "\n");

    }

    public static void main(String[] args) {
        maxNumInArray();
    }
}
