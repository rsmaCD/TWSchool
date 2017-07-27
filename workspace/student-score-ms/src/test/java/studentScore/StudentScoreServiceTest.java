package studentScore;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentScoreServiceTest {

    private StudentManager mockStudentManager;
    private Reports mockReports;
    private StudentScoreService studentScoreSystem;
    private Score score;

    @Before
    public void setUp() throws Exception {

        mockStudentManager = mock(StudentManager.class);
        mockReports = mock(Reports.class);
        studentScoreSystem = new StudentScoreService(mockStudentManager,mockReports);

        score = new Score(2, 2, 2, 2);
    }

    @Test
    public void should_call_creatstudent_onece_when_input_legal() throws Exception {
        studentScoreSystem.createStudent("Tom,112,2,2,2,2");
        verify(mockStudentManager, times(1)).createStudent("112","Tom",score);
    }

    @Test
    public void should_return_false_when_input_illegal() throws Exception {
        studentScoreSystem.createStudent("Tom,112,a,2,2,2");
        verify(mockStudentManager, times(0)).createStudent("112","Tom",score);
    }

    @Test
    public void should_return_null_When_input_illegal() throws Exception {
        assertEquals(null,studentScoreSystem.createReports("110aa,111qqq"));
    }

    @Test
    public void should_call_creatreports_once__When_input_legal() throws Exception {

        studentScoreSystem.createReports("110,111");
        verify(mockReports, times(1)).createReports(asList("110","111"));

    }
}
