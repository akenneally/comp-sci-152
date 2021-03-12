package bsu.comp152;

import java.util.Scanner;

public class SmallestInteger {
    public static void main(String[] args) {
        //tell the user what the program does
        System.out.println("This program finds the smallest of integers you enter.");
        //tell the user what to do and how to quit
        System.out.println("Enter an integer (Q or q to quit):");
        //create scanner object keyboard to collect user's input
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.next();
        //set smallestInt to 0
        int smallestInt = 0;
        //while the user's input contains q or Q, break out of loop
        while (true) {
            if (userInput.contains("q") || userInput.contains("Q")) {
                break;
            }
            if (userInput.equalsIgnoreCase("q")) {
                break;
            }
            //if user's input does not break out of loop
            //compare current smallestInt with user's input
            //if smallerInt is greater than user's input
            //make user's input the new value of smallestInt
            if (smallestInt > Integer.parseInt(userInput)) {
                smallestInt = Integer.parseInt(userInput);
            }
        }
        //print the smallest integer entered to user using formatted print
        System.out.printf("The smallest number you entered is %s", smallestInt);
    }
}