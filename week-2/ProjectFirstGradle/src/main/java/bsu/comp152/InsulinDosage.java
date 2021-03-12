package bsu.comp152;

public class InsulinDosage
{

    public static void main(String[] args)
    {
        System.out.println(dosage(100, 200, 54,76,3));
        //System.out.println("This program calculates the dosage of insulin for you.");
        //System.out.println("Enter the current blood sugar.");
        //int current_blood_sugar;
        //System.out.println("Enter the target blood sugar.");
        //int target_blood_sugar;
        //System.out.println("Enter the number of carbohydrates that are equivalent to one unit of insulin.");
        //int carb_equivalency;
        //System.out.println("Enter the amount of carbohydrates planned to consume.");
        //int carb_planned;
        //System.out.println("Enter the level of exercise planned, 0 being no exercise and 3 being heavy exercise.");
        //int planned_exercise_level;
        //System.out.println("This is the number of units of insulin to be taken before a meal " + dosage);
    }

    public static float dosage(int current_blood_sugar, int target_blood_sugar, int carb_equivalency, int carb_planned, int planned_exercise_level)
    {
        float get_insulin_dosage = (((current_blood_sugar / target_blood_sugar) + (carb_planned / carb_equivalency)) - planned_exercise_level);

        System.out.println("This program calculates the dosage of insulin for you.");
        System.out.println("Enter the current blood sugar.");
        //int current_blood_sugar;
        System.out.println("Enter the target blood sugar.");
        //int target_blood_sugar;
        System.out.println("Enter the number of carbohydrates that are equivalent to one unit of insulin.");
        //int carb_equivalency;
        System.out.println("Enter the amount of carbohydrates planned to consume.");
        //int carb_planned;
        System.out.println("Enter the level of exercise planned, 0 being no exercise and 3 being heavy exercise.");
        //int planned_exercise_level;
        //dosage = ();
        System.out.println("This is the number of units of insulin to be taken before a meal " + get_insulin_dosage);
        return get_insulin_dosage;


    }
}
