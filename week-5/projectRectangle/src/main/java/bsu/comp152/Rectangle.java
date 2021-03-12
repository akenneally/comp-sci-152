package bsu.comp152;

/**
 * Rectangle class
 *
 * A class for Rectangle objects
 *
 * Starter code by Laura K. Gross, COMP 152, Bridgewater State University
 *
 * Completed by: Alicia Kenneally, akenneally@student.bridgew.edu
 *         date: 3/1/2021
 */
public class Rectangle {

    /* This class is a (blueprint) class
     * for creating and manipulating Rectangle objects.
     */

    /* Objects have information
     * and actions associated with them.
     */

    /* We store the information in "instance variables".
     * These keep the data for the Rectangle object "private":
     * The data length and width are accessible directly only from
     * inside the Rectangle class.
     */
    private double length;
    private double width;

    /* This is a "constructor" for a Rectangle object.
     * A constructor has no return type in the header, not even void!
     * A constructor has the same name as the class.
     */
    public Rectangle(double len, double wid){
        length = len;
        width = wid;
    }

    /* These instance methods for actions on Rectangle objects
     * are "accessors" or "getters".
     * We call them on Rectangle objects to get information about the
     * Rectangle objects.
     */
    public double getLength(){
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    public boolean equals(Rectangle other) {
        return (length == other.length) && (width == other.width);
    }

    /* These instance methods are "mutators" or a "setters".
     * We call them on Rectangle objects to changes the
     * Rectangle object's data.
     */

    public void rotate() {
        //this method is a mutator
        //it changes the Rectangle object's data
        double tempWidth = width;
        width = length;
        length = tempWidth;
        }

    public void setLength(double len){
        length = len;
    }

    public void setWidth(double wid){
        width = wid;
    }
}
