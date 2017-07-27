package studentScore;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by rsma on 27/07/2017.
 */
public class StudentScoreAppTest {

    StudentScoreService studentScoreService;
    private StudentScoreApp studentScoreApp;

    @Before
    public void setUp() throws Exception {
        studentScoreService = mock(StudentScoreService.class);
        studentScoreApp = new StudentScoreApp(studentScoreService);
    }

    @Test
    public void should_call_creatstudent_when_input_legal() throws Exception {
        studentScoreApp.creatStudent("111,Tom,2,2,2,2");
        verify(studentScoreService,times(1)).createStudent("111,Tom,2,2,2,2");
    }

    @Test
    public void should_call_creatreport_when_input_legal() throws Exception {
        studentScoreService.createReports("111,111,110");
        verify(studentScoreService,times(1)).createReports("111,111,110");
    }
}
