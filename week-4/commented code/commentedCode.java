//package bsu.comp152;
//
//import java.util.Scanner;
//
//public class SmallestInteger {
//    public static void main(String[] args) {
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("This program finds the smallest of the integers you enter.");
//        System.out.println("Enter an integer (Q or q to quit):");
//        String userInput = keyboard.next();
//        int counter = 0;
//        //String userInput = keyboard.next();
//        // 5/n6/nQ
//        int smallestInt = 0;
////if the first time running it
//        if (counter == 0) {
//            smallestInt = Integer.parseInt(userInput);
//        }
//
//        while (true) {
//            // debug what the hell userInput is
//            // we expect it to contain q Q
//            // if 5/n6/nQ
//            // parse that string and pull the Q or q
//            // one way would be to split string by new line "/n"
//            if (userInput.contains("q") || userInput.contains("Q")) {
//                break;
//            }
//            if (userInput.equalsIgnoreCase("q")) {
//                break;
//            }
//            if (smallestInt > Integer.parseInt(userInput)) {
//                smallestInt = Integer.parseInt(userInput);
//            }
//
//            counter++;
//
//        }
//
//        // they have quit so now what
//        System.out.printf("The smallest number you entered is %s", smallestInt);
//
//
//    }
//}
