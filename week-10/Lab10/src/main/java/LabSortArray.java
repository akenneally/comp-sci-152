import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class LabSortArray {
    public static void main (String[] args){

        //create ArrayList to hold integers
        ArrayList<Integer> numberList = new ArrayList<>();

        //add some integers to the ArrayList
        numberList.add(1);
        numberList.add(3);
        numberList.add(7);
        numberList.add(5);
        numberList.add(12);
        numberList.add(10);

        //print unsorted values
        System.out.println("The unsorted values are: ");
        System.out.println(numberList);

        //Sort values in ArrayList
        Collections.sort(numberList);
        System.out.println(numberList);
        

    }

}
