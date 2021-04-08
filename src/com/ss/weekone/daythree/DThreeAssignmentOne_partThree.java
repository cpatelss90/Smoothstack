package com.ss.weekone.daythree;


import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class DThreeAssignmentOne_partThree {
    public static void main(String[] args) {
        FileInputStream fileIn = null;
        Scanner scan  = null;

        try {
            fileIn = new FileInputStream("/Users/charvin/desktop/dthree.txt");
            int count = 0;
            char c = 'a';
            String str = "";
            scan  = new Scanner(fileIn);

            while(scan.hasNextLine()){
                for(int i = 0; i < str.length();i++){
                    if(str.charAt(i) == c){
                        count++;
                    }
                }
            }

            System.out.println("Total: " + count);

        }
        catch (Exception e){

        }
        finally {
            scan.close();
        }


    }
}
