package bsu.comp152;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.MatcherAssert.*;

import static org.mockito.Mockito.*;

public class StudentTest {

    Student testStudent;

    private String studentName;
    private String profName;
    private String deptName;
    private Professor mockProf;
    private int firstIDNumber;


    @BeforeEach
    public void setup() {
        // makes a Student with ID firstIDNumber, name Student Name, advisor Advisor Name
        firstIDNumber = 0;
        studentName = "Student Name";
        profName = "Professor Name";
        deptName = "Department Name";
        // Use a mock professor for testing independently of Professor class
        // honestly this may not be necessary if the advisee list isn't a thing
        mockProf = mock(Professor.class);
        when(mockProf.getName()).thenReturn(profName);
        Student.nextID = firstIDNumber;
        testStudent = new Student(studentName, mockProf);
    }

    @Test
    public void getNameReturnsName() {
        assertThat(studentName, equalTo(testStudent.getName()));
    }

    @Test
    public void getAdvisorReturnsAdvisor() {
        assertThat(profName, equalTo(testStudent.getAdvisor().getName()));
    }

    @Test
    public void changeAdvisorChangesAdvisor() {
        Professor secondProf = mock(Professor.class);
        when(secondProf.getName()).thenReturn("New Advisor");
        testStudent.changeAdvisor(secondProf);
        assertThat("New Advisor", equalTo(testStudent.getAdvisor().getName()));
    }

    @Test
    public void getIDReturnsID() {
        assertThat(firstIDNumber, equalTo(testStudent.getStudentID()));
    }

    @Test
    public void makingAnotherStudentIncrementsAssignedID() {
        Student secondTestStudent = new Student("Second Student", mockProf);
        assertThat(firstIDNumber+1, equalTo(secondTestStudent.getStudentID()));
    }

    @Test
    public void getGPAReturns0Initially() {
        assertThat(0.0, closeTo(testStudent.getGPA(), 0.001));
    }

    @Test
    public void takingOneClassCalculatesGPA() {
        testStudent.takeClass(4, 2.0);
        assertThat(2.0, closeTo(testStudent.getGPA(), .0001));
    }

    @Test
    public void takingTwoClassesCalculatesGPA() {
        testStudent.takeClass(4, 4.0);
        testStudent.takeClass(8, 2.0);
        assertThat(2.66666, closeTo(testStudent.getGPA(), .0001));
    }

    @Test
    public void getCreditHoursReturns0Initially() {
        assertThat(0, equalTo(testStudent.getCreditHours()));
    }

    @Test
    public void takingOneClassUpdatesNumCredits() {
        int initialCredits = testStudent.getCreditHours();
        testStudent.takeClass(3, 4.0);
        assertThat(initialCredits + 3.0, closeTo(testStudent.getCreditHours(), .0001));
    }

    @Test
    public void takingTwoClassesUpdatesNumCredits() {
        int initialCredits = testStudent.getCreditHours();
        testStudent.takeClass(4, 4.0);
        testStudent.takeClass(5, 2.0);
        assertThat(initialCredits + 9.0, closeTo(testStudent.getCreditHours(), .0001));
    }

    @Test
    public void studentToStringContainsName(){
        assert (testStudent.toString().contains(testStudent.getName()));
    }

    @Test
    public void studentToStringContainsID() {
        assert(testStudent.toString().contains(String.valueOf(testStudent.getStudentID())));
    }

    @Test
    public void studentToStringContainsAdvisor() {
        assert(testStudent.toString().contains(testStudent.getAdvisor().getName()));
    }

    @Test
    public void studentToStringContainsGPA() {
        assert (testStudent.toString().contains(String.valueOf(testStudent.getGPA())));
    }
}
