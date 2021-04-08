package com.ss.weekone.daythree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;


/**
 * @author Charvin Patel
 */

public class DThreeAssignmentOne_partTwo {

    // This method appends a user inputted text into a file
    public static void appendText() {
        FileWriter fWriter = null;
        BufferedWriter bWriter = null;

        try {
            fWriter = new FileWriter("resource/append.txt", true);
            bWriter = new BufferedWriter((fWriter));
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please write a text to be appended in the file: ");
            String s = " " + read.readLine();
            bWriter.append(s);
        } catch (Exception e) {
            System.out.println("Exception: " + e);

        } finally {
            if (fWriter != null && bWriter != null) {
                try {
                    bWriter.close();
                    fWriter.close();
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }
        }

        System.out.println("Your text is successfully inserted!");

    }

    // Main calls appendText() to append the text into a file
    public static void main(String[] args) {
        appendText();
    }
}

