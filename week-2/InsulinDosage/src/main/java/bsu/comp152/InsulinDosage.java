/**
 * InsulinDosage -
 * A class for Project 1, COMP 152
 *
 * Starter code Laura K. Gross, laura.gross@bridgew.edu, 2/2021
 *
 * Completed by: Alicia Kenneally , akenneally@student.bridgew.edu , 2/23/2021
 */

package bsu.comp152;

public class InsulinDosage {

    public static void main(String[] args) {
        System.out.println("This program returns the insulin dosage needed " +
                "before a meal to a high degree of precision.");
        System.out.println(dosage(210 , 100 , 10 , 60 ,2));
        System.out.println(dosage(220 , 100 , 10 , 60 ,2));
        System.out.println(dosage(210 , 100 , 10 , 62 ,2));
        System.out.println(dosage(220 , 100 , 10 , 62 ,2));
    }

    public static double dosage(int currentSugar,
                                int targetSugar,
                                int carbEquivalency,
                                int plannedCarbs,
                                int plannedExercise) {

        double sugars = currentSugar - targetSugar;
        double carbs = (double)plannedCarbs / (double)carbEquivalency;
        return ((sugars / 55) + (carbs)) - plannedExercise;
    }
}