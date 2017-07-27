package studentScore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentScoreSystemTest {

    private StudentManager mockStudentManager;
    private Reports mockReports;
    private StudentScoreSystem studentScoreSystem;
    private String reports;
    private Score score;

    @Before
    public void setUp() throws Exception {

        mockStudentManager = mock(StudentManager.class);
        studentScoreSystem = new StudentScoreSystem(mockStudentManager,mockReports);

        score = new Score(2, 2, 2, 2);
        //when(mockStudentManager.createStudent("112","Tom",score)).thenReturn(true);

//        reports = "成绩单\n" +
//                "姓名|数学|语文|英语|编程|平均分|总分 \n" +
//                "========================\n" +
//                "Tom|2|1|1|1|1.25|5\n" +
//                "Lili|2|2|2|2|2.00|8\n" +
//                "========================\n" +
//                "全班总平均分：1.63\n" +
//                "全班总分中位数：6.50";
//        when(mockReports.createReports()).thenReturn(reports);
    }

    @Test
    public void should_call_creatstudent_onece_when_input_legal() throws Exception {
        studentScoreSystem.createStudent("112,Tom,2,2,2,2");
        verify(mockStudentManager, times(1)).createStudent("112","Tom",score);
    }

    @Test
    public void should_return_false_when_input_illegal() throws Exception {
        assertEquals(false, studentScoreSystem.createStudent("112,Tom,a,2,2,2"));
    }

    @Test
    public void should_return_null_When_input_illegal() throws Exception {
        assertEquals(null,studentScoreSystem.createReports("110aa,111qqq"));
    }

    @Test
    public void should_return_reports_When_input_legal() throws Exception {

        studentScoreSystem.createReports("110,111");
        verify(mockReports, times(1)).createReports();

    }
}
