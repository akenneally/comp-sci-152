package bsu.comp152;

import java.util.ArrayList;

public class Professor {
    //define three instance variables adviseeList, name, and department
    public ArrayList<Student> adviseeList;
    private String name;
    private String department;
    //constructor takes two params
    public Professor(String profName, String dept) {
        //initialize instance variable name w/ profName param
        //initialize instance variable dept w/ dept param
        //initialize instance variable adviseeList explicitly with default val null
        name = profName;
        department = dept;
        adviseeList = new ArrayList();
    }
    //addAdvisee method takes one param
    //adds param to instance variable adviseeList
    public void addAdvisee(Student advisee){
        adviseeList.add(advisee);
    }
    //removeAdvisee method takes one param
    //removes param from instance variable adviseeList if param is in adviseeList
    //to do: could initialize a counter to 0, declare Student object called advisee
    //initialize advisee to first student id for param
    //could increment counter and get advisee at index value by counter
    public void removeAdvisee(Student advisee){
        adviseeList.remove(advisee);
    }
    //getName method takes no params
    //is an accessor for the instance variable name
    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}


