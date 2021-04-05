package bsu.comp152;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class ProfessorTest {
    private Professor testProf;
    private Student mockStudent;

    private String profName;
    private String deptName;
    private String studentName;

    @BeforeEach
    public void setup() {
        profName = "Professor Name";
        studentName = "Student Name";
        deptName = "Department Name";

        // make a test student and test professor
        testProf = new Professor(profName, deptName);
        mockStudent = mock(Student.class);

    }

    @Test
    public void getNameReturnsProfessorName() {
        assertThat(profName, equalTo(testProf.getName()));
    }

    @Test
    public void profToStringContainsName(){
        assert (testProf.toString().contains(profName));
    }

    @Test
    public void profToStringContainsDept(){
        assert (testProf.toString().contains(deptName));
    }
}
