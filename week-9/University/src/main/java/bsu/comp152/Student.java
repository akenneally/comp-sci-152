package bsu.comp152;

public class Student {
    //  Define five instance variables
    //  one class/static variable nextID
    public static int nextID = 2000;

    public int studentID;
    private double gpa;
    private String name;
    private Professor advisor;
    private int numberOfCredits;

    // constructor - takes two parameters
    //initialize instance variable name w/ studentName param
    //initialize instance variable advisor w/ initialAdvisor param
    public Student(String studentName, Professor initialAdvisor){
        //initialize instance variable gpa to 0.0
        //initialize instance variable numberOfCredits to 0
        //initialize instance variable StudentID to value of
        //class/static variable nextID
        //should increment class variable nextID
        name = studentName;
        advisor = initialAdvisor;
        gpa = 0.0;
        numberOfCredits = 0;
        studentID = nextID;
        nextID++;
    }

    //takeClass method takes two params
    //method will be called when student takes a class, earning
        //a certain number of credits and certain grade for class
    //method should update instance variables gpa and numberOfCredits
        //taking new course into account
    //When you use the programming process to develop your algorithm
    // to update the GPA and number of credits, you will assume that the GPA is the
    // total number of points earned divided by the total number of credits taken.
    // The points earned for each class consist of the number of credits for the class times the
    // grade as a decimal number (4.0 means A, 3.0 means B, 2.0 means C, 1.0 means D, 0.0 means F).
    // takeClass(4,3.0)
    public void takeClass(int credits, double grade){
        // update the instance variable numberOfCredits which is the cumulative
        numberOfCredits += credits;
        // update the instance variable gpa
        gpa = ((numberOfCredits * gpa) + (grade * credits)) / numberOfCredits;
    }

    //changeAdvisor method takes one param
    //should update instance variable 'advisor' to new value from param
    public void changeAdvisor(Professor newAdvisor){
        advisor = newAdvisor;
//        return newAdvisor;
    }

    //getName method should take no params
    //method is an accessor for instance variable 'name'
    public String getName(){
        return name;
        }

    //getGPA method takes no params
    //accessor for instance variable 'gpa'
    public double getGPA(){
        return gpa;
        }

    //getCreditHours method takes no param
    //accessor for instance variable 'numberOfCredits'
    public int getCreditHours(){
        return numberOfCredits;
        }

    //getStudentID method takes no params
    //accessor for instance variable 'studentID'
    public int getStudentID(){
        return studentID;
        }

    //getAdvisor method takes no params
    //accessor for instance variable 'advisor'
    public Professor getAdvisor(){
        return advisor;
        }

    //toString method takes no params
    //creates a string that details student's
        //name, studentID, advisor's name, gpa
    //make sure string makes it clear what each piece of data they are
    //return string
    public String toString(){
        String studentsName = "\nStudents Name: " + getName();
        String studentID = "\nStudent ID: " + getStudentID();
        String advisorsName = "\nAdvisor's Name: " + getAdvisor();
        String gpa = "\nStudent's GPA: " + Double.toString(getGPA());

        return studentsName + studentID + advisorsName + gpa;
        }

}
