package com.company;

public class OverTime {

    public static void main(String[] args) {

        System.out.println(timeAndAHalf(43, 13.5));
        System.out.println(timeAndAHalf(54, 15.5));
        System.out.println(timeAndAHalf(75, 25.9));
        System.out.println(timeAndAHalf(70, 17.8));

    }

    public static double timeAndAHalf(int numberOfHoursWorked, double hourlyRate) {

        return ((40 * hourlyRate) + ((hourlyRate/2) * (numberOfHoursWorked - 40)));

    }



}
