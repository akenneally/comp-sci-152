import java.util.ArrayList;

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
        ArrayTools.selectionSort(values);
        System.out.println(numberList);

    public static void selectionSort(int[] array){
        int startScan, index, minIndex, minValue;
        for (startScan = 0; startScan < (numberList.length; startScan++){
            minIndex = startScan;
            minValue = array[startScan];
            for (index = startScan + 1; index < numberList.length; index++){
                if (array[index] < minValue){
                    minValue = array[index];
                    minIndex = index;
                }
            }
            array[minIndex] = array[startScan];
            array[startScan] = minValue;
        }
        }
    }
}
