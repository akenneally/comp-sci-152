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
    public Student(Professor initialAdvisor, String studentName){
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

    //takeClass method takes two params
    //method will be called when student takes a class, earning
        //a certain number of credits and certain grade for class
    //method should update instance variables gpa and numberOfCredits
        //taking new course into account
    public double takeClass(int credits, double grade){

        }

    //changeAdvisor method takes one param
    //should update instance variable 'advisor' to new value from param
    public Professor changeAdvisor(Professor newAdvisor){
        advisor = newAdvisor;

        }

    //getName method should take no params
    //method is an accessor for instance variable 'name'
    public String getName{

        }

    //getGPA method takes no params
    //accessor for instance variable 'gpa'
    public double getGPA{

        }

    //getCreditHours method takes no param
    //accessor for instance variable 'numberOfCredits'
    public int getCreditHours{

        }

    //getStudentID method takes no params
    //accessor for instance variable 'studentID'
    public int getStudentID{

        }

    //getAdvisor method takes no params
    //accessor for instance variable 'advisor'
    public Professor getAdvisor{

        }

    //toString method takes no params
    //creates a string that details student's
        //name, studentID, advisor's name, gpa
    //make sure string makes it clear what each piece of data they are
    //return string
    public String toString{
        String studentDetails = "";
        System.out.println("The student's name is: , their ID number is: ," +
                "their advisor's name is: , and current gpa is: ");

        return studentDetails;
        }

    }
}
