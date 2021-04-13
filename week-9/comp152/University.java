package bsu.comp152;
import java.util.ArrayList;
import java.util.Scanner;

/** A class to create University objects
 * Starter code Laura K. Gross, COMP 152, Bridgewater State University
 * Completed by: [student name], [student email]
 * date: [date of completion]
 */
public class University {

    // Give the whole class access to the console.
    public static Scanner keyboard = new Scanner(System.in);

    // TODO: Define two instance variables studentList and faculty.
    private ArrayList<Student> studentList = null;
    private ArrayList<Professor> faculty = null;

    // TODO: Define a constructor as on project sheet.
    public University() {
        studentList = new ArrayList<>();
        faculty = new ArrayList<>();
    }

    // TODO: Define the hireProfessor method as on project sheet.
    public void hireProfessor(Professor newProfessor) {
        faculty.add(newProfessor);
    }

    // TODO: Define the admitStudent method as on project sheet.
    public void admitStudent(Student newStudent) {
        studentList.add(newStudent);
    }

    // TODO: Define the findStudent method as on project sheet.
    public ArrayList<Student> findStudent(int studentID) {
        var foundStudentList = new ArrayList<Student>();
        studentList.forEach(student -> {
            if (student.getStudentID() == studentID) {
                foundStudentList.add(student);
            }
        });
        return foundStudentList;
    }

    // TODO: Define the graduateStudents method as on project sheet.
    public void graduateStudents() {
        var students = new ArrayList<>(this.studentList);

        students.forEach(s -> {
            if (s.getGPA() >= 2.0 && s.getCreditHours() >= 20) {
                studentList.remove(s);

                var currentProfessor = s.getAdvisor();
                currentProfessor.removeAdvisee(s);

                if (s.getGPA() >= 3.7)
                    System.out.println("Great " + s.getName() + " you made it with high honors");
                else if (s.getGPA() >= 3.3)
                    System.out.println("Great " + s.getName() + " you made it with honors");
                else
                    System.out.println("Great " + s.getName() + " you made it");
            }
        });
    }

    public void runUniversity() {
        int choice;
        do {
            // Display top-level menu:
            System.out.println("1 - Hire a professor");
            System.out.println("2 - Admit a student");
            System.out.println("3 - Process graduation");
            System.out.println("4 - Look up a student");
            System.out.println("5 - Exit main menu");
            System.out.print("Which would you like to do? ");

            choice = keyboard.nextInt();
            // Consume newline character.
            keyboard.nextLine();

            switch (choice) {
                case 1:
                    hireAProfessor();
                    break;
                case 2:
                    admitAStudent();
                    break;
                case 3:
                    graduateStudents();
                    break;
                case 4:
                    lookUpAStudent();
                    break;
                case 5:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (choice != 5);
    }

    private void hireAProfessor() {
        System.out.print("Enter the professor's name.");
        var name = keyboard.nextLine();
        System.out.print("Enter the professor's department.");
        var dept = keyboard.nextLine();
        hireProfessor(new Professor(name, dept));
    }

    private void admitAStudent() {
        System.out.print("Enter the student's name.");
        var name = keyboard.nextLine();

        if (faculty.isEmpty()){
            System.out.println("No professors yet, cannot add student.");
            return;
        }

        var randomInt = (int)(Math.random() * faculty.size()-1);
        var randomProfessor = faculty.get(randomInt);
        var newStudent = new Student(name, randomProfessor);
        randomProfessor.addAdvisee(newStudent);
        admitStudent(newStudent);
    }

    private void lookUpAStudent(){
        System.out.print("Enter the student ID to look up.");
        var ID = keyboard.nextInt();
        keyboard.nextLine();

        var foundStudentList = findStudent(ID);

        if (foundStudentList.isEmpty()) {
            System.out.println("Student with ID " + ID + " was not found.");
            return;
        }

        var foundStudent = foundStudentList.get(0);
        System.out.println("Found " + foundStudent.toString());

        // Enter the student menu for this student:
        int choice;
        do {
            System.out.println("1 - Enter credits and grade for student");
            System.out.println("2 - Assign advisor to student");
            System.out.println("3 - Exit");
            System.out.print("Which would you like to do? ");

            choice = keyboard.nextInt();
            // Consume the newline character.
            keyboard.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of credits for student.");
                    var credits = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("Enter grade for student.");
                    var grade = keyboard.nextFloat();
                    keyboard.nextLine();
                    foundStudent.takeClass(credits, grade);
                    break;
                case 2:
                    System.out.print("Enter advisor name from the list.");
                    faculty.forEach(p -> { System.out.println("\n" + p.getName()); });
                    var advisorName = keyboard.nextLine();

                    System.out.print("Enter department for this advisor.");
                    var department = keyboard.nextLine();
                    var newProfessor = new Professor(advisorName, department);

                    var currentAdvisor = foundStudent.getAdvisor();
                    currentAdvisor.removeAdvisee(foundStudent);

                    foundStudent.changeAdvisor(newProfessor);
                    newProfessor.addAdvisee(foundStudent);
                    break;
                case 3:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (choice != 3);
    }
}
