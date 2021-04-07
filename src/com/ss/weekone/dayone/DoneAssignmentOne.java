package com.ss.weekone.dayone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * @author charvin
 */
public class DoneAssignmentOne {

    /**
     * @param args
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));


        Random randNum = new Random();

        int low = 1;
        int high = 100;

        // Generates a random number between 1 and 100
        int rNum = randNum.nextInt(high - low) + low;


        System.out.println("Please Guess the Number between 1 to 100 ");

        int userNum = Integer.parseInt(read.readLine());


        // Gives 5 chances to guess it right
        for (int i = 0; i < 4; i++) {

            // User guessed out of range( +- 10) number.
            if (userNum > (rNum + 10) || userNum < (rNum - 10)) {

                System.out.println("Please Guess again: ");
                userNum = Integer.parseInt(read.readLine());

            }


            if ((userNum == rNum || // user num is same as random num
                    (userNum >= rNum - 10 && userNum <= rNum) || // user num is within random num & (random num - 10) range
                    (userNum <= rNum + 10 && userNum >= rNum))) // user num is within random num & (random num + 10) range
            {
                System.out.println("Congrats your guess is within range of random number: " + rNum);
                return;
            }

        }

        System.out.println("Sorry the random Num was: " + rNum);

    }

}


