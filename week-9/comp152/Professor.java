package bsu.comp152;
import java.util.ArrayList;

/** A class to create Professor objects
 * Starter code Laura K. Gross, COMP 152, Bridgewater State University
 * Completed by: [student name], [student email]
 * date: [date of completion]
 */
public class Professor {

    // instance fields/variables
    private ArrayList<Student> adviseeList;
    private String name;
    private String department;

    // constructor
    // TODO: Write constructor header.
    // TODO: Initialize the instance variable name with the profName parameter.
    // TODO: Initialize the instance variable department with the dept parameter.
    // Initialize the instance variable adviseeList via
    // adviseeList = new ArrayList<Student>(); // (Don't initialize to null.)
    public Professor(String profName, String dept) {
        name = profName;
        department = dept;
        adviseeList = new ArrayList<>();
    }

    // accessors and mutators

    /**
     * A method to remove an advisee from the advisee list
     * @param formerAdvisee
     */
    public void removeAdvisee(Student formerAdvisee){
        adviseeList.remove(formerAdvisee);
    }

    public String getName() { return name; }

    public void addAdvisee(Student student) {
        adviseeList.add(student);
    }

    @Override
    public String toString() {
        return "Professor{name=" + name + ", Department=" + department + "}";
    }

}
