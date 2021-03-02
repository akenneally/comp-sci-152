package bsu.comp152;

/**
 * Main -
 *
 * A class for creating and manipulating Rectangle objects
 *
 * It contains a driver program or client code for the Rectangle class.
 *
 * Starter code Laura K. Gross, laura.gross@bridgew.edu, 2/2021
 *
 * Completed by: [student name], [student email], [date of completion]
 */
public class Main {

    public static void main(String[] args){

        /* Before we wrote our own Rectangle constructor, we called the default one
         * in this inline initialization:
         */
        // Rectangle rect1 = new Rectangle();
        /* It created a Rectangle object with length 0.0 and width 0.0.
         * The default Rectangle constructor with no parameters no longer worked after we wrote our
         * own constructor!
         */

        /* Call the constructor from the Rectangle class that takes two
         * parameters.
         */
        Rectangle rect1 = new Rectangle(5, 1.3);
        Rectangle rect2 = new Rectangle(5, 1.3);
        // To create a Rectangle object is to create an instance of the Rectangle class.
        // We instantiate the Rectangle class.

        // Call the getters getLength and getWidth on rect1, and print the returned values.
        System.out.println(rect1.getLength());
        System.out.println(rect1.getWidth());

        // Before we wrote our own toString method, we did
        // System.out.println(rect1);
        // and the memory address in hexadecimal (hex) was printed (not very useful).

        /* Once we wrote our own toString method to override the default,
         * printing became more useful!
         */
        System.out.println(rect2);
        // Note we can also call the toString method on a Rectangle object explicitly:
        System.out.println(rect2.toString());

        /* Don't use == for objects!
         * These two rectangles should be considered the same because they have the same
         * dimensions, but == will return false because the two objects have different
         * memory addresses stored in the reference variables rect1 and rect2:
         */
        System.out.println(rect1 == rect2);

        // Instead write an equals method in the Rectangle class, and call it.
        System.out.println(rect1.equals(rect2));
        // Now we can see that the two Rectangle objects are the same.

        /* We can call setters on Rectangle objects to change the values of the
         * instance variables.
         */
        rect1.setLength(12.5);
        rect1.setWidth(3);

        // The Rectangle objects have now changed!
        System.out.println(rect1);
        System.out.println(rect2);

        // The Rectangles objects are no longer equal.
        System.out.println(rect1.equals(rect2));
    }
}
