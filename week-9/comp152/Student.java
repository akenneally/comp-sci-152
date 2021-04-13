package bsu.comp152;

/** A class to create Student objects
  * Starter code Laura K. Gross, COMP 152, Bridgewater State University
  * Completed by: [student name], [student email]
  * date: [date of completion]
 */

public class Student {
    // class/static variable
    public static int nextID = 2000;
    // instance fields/variables
    private int studentID;
    private double gpa;
    private String name;
    private Professor advisor;
    private int numberOfCredits;

    // constructor
    public Student(String studentName, Professor initialAdvisor){
        name = studentName;
        advisor = initialAdvisor;
        gpa = 0.0;
        numberOfCredits = 0;
        studentID = nextID++;
    }

    // setters

    public void takeClass(int credits, double grade){
        // --- example
        // gpa = 2.0
        // numCredits = 8
        // totalPoints = 16  // gpa * numCredits
        var totalPoints = gpa * numberOfCredits;

        // --- new class example
        // gpa/grade = 3.0
        // credits = 4
        // totalPoints = 12  // gpa * credits
        var pointsForThisClass = grade * credits;

        this.numberOfCredits += credits;

        this.gpa = (totalPoints + pointsForThisClass) / numberOfCredits;
    }

    public void changeAdvisor(Professor newAdvisor){
        advisor = newAdvisor;
    }

    // getters

    public double getGPA() {
        return gpa;
    }

    public int getCreditHours() {
        return numberOfCredits;
    }

    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", studentID=" + studentID + ", advisor=" + advisor.getName() + ", gpa=" + gpa + "}";
    }

    public Professor getAdvisor() {
        return advisor;
    }
}