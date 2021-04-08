package com.ss.weekone.daythree;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class DThreeAssignmentOne_partTwo {

    // here
    public static void main(String[] args) {
        FileWriter fWriter = null;
        BufferedWriter bWriter = null;

        try {
            fWriter = new FileWriter("resource/append.txt", true);
            bWriter = new BufferedWriter((fWriter));
            String s = " this is appended text";
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
    }
}

