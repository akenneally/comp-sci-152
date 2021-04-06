package bsu.comp152;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class University {
    //Define two instance variables studentList and faculty
    private ArrayList<Student> studentList;
    private ArrayList<Professor> faculty;

    //constructor takes no params
    //should initialize instance variable studentList with new (empty) arrayList
    //should initialize instance variable faculty with new (empty) arrayList
    public University(){
        studentList = new ArrayList<Student>();
        faculty = new ArrayList<>();
    }
    //hireProfessor method takes one param
    //add param to instance variable 'faculty'
    public void hireProfessor(Professor newFaculty){
        faculty.add(newFaculty);
    }

    //admitStudent method takes one param
    //adds param to instance variable studentList
    public void admitStudent(Student newStudent){
        studentList.add(newStudent);
    }

    //findStudent method takes one param
    //needs to search through studentList to find student with right student ID
    //needs to return arrayList foundStudent
        //if student was found, foundStudent needs to include the target Student object
        //if student was not found, needs to return an empty foundStudent
    public int findStudent(int studentID){

    }

    //graduateStudents method takes no params
    //should iterate through student list
    //at each pass through the loop
        //if student has a gpa of at least 2.0
        //has at least 20 credits
        //method should remove student from student list
        //remove student from professor's advisee list
        //print a congrats message
        //print student's name
        //if GPA is higher than 3.7 -
            // print student graduates with high honors
        //if student didn't earn high honors but has gps of at least 3.3 -
            //print they graduate with honors
    public Student graduateStudents(){

    }

    /**
     * The runUniversity method should take no parameters.
     * Feel free to break this method into pieces and make private methods to do parts of what is listed here. You can then call those private methods from this method.
     * The menus that are discussed here can be structured to do (present) the options while the user's choice is not "Exit".
     * A switch statement inside a do-while could be a useful implementation of the menus, where each case is a call to a different private method that you write.

     * The method must display a top level menu, which provides the following options for the user:
     * Hire a professor
     * First prompt the user for the professor's name.
     * Then prompt the user for the professor's department.
     * Create a new Professor object.
     * Call the hireProfessor method.

     * Admit a student
     * Prompt the user to enter the student's name.
     * Randomly select a professor from the faculty list to be the student's initial advisor.
     * Create a new Student object.
     * Call the admitStudent method.

     * Process graduation
     * Call the graduateStudents method.

     * Look up a student.
     * Prompt the user to enter the student ID.
     * Call findStudent to obtain the ArrayList that is either empty or contains the found Student.
     * If the student was found,
     * print the student's details (using toString);
     * give the user the option to enter the student menu for this student. (See below.)
     * If the student was not found, print a message to that effect.

     * Exit
     * End the program.

     * The Student menu must provide the following options for the user:
     * Enter the credits and grade for the student
     * Prompt the user to enter the number of credits for the class.
     * Prompt the user to enter the student's grade for the class (4.0, 3.0, 2.0, 1.0, 0.0).
     * Call takeClass on the student.

     * Assign an advisor to the student
     * Show a list of all of the professors. (Iterate through the faculty list and print each professor.)
     * Prompt the user to draw from the printed list to enter the name for the advisor to assign to the student.
     * Prompt the user to enter the department name for the advisor.
     * Get the student's current advisor, and call the method removeAdvisee on that professor.
     * Assign the new advisor to the student by calling the method changeAdvisor on the student.
     * Add the student to the new advisor's advisee list by calling the method addAdvisee on the new advisor.

     * Exit
     * End the program.
     */

}
