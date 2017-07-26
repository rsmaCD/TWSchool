package studentScore;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentScoreSystemTest {

    private StudentManager mockStudentManager;

    @Before
    public void setUp() throws Exception {
        mockStudentManager = mock(StudentManager.class);

        Score score = new Score(2, 2, 2, 2);
        when(mockStudentManager.createStudent("112","Tom",score)).thenReturn(true);
    }

    @Test
    public void should_call_creatstudent_when_input_legal() throws Exception {
        StudentScoreSystem.manager = mockStudentManager;
        StudentScoreSystem studentScoreSystem = new StudentScoreSystem();
        assertEquals(true,studentScoreSystem.CreateStudent("112,Tom,2,2,2,2"));
    }
}
