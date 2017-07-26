package studentScore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by rsma on 26/07/2017.
 */
public class ReportsTest {

    private Reports reports;
    private StudentManager mockStudentManager;
    private final static String reportsHeadTemplate = "成绩单\n姓名|数学|语文|英语|编程|平均分|总分 \n========================\n";
    private final static String reportsTailTemplate = "========================\n全班总平均分：%.2f\n全班总分中位数：%d";
    private Student student;

    @Before
    public void setUp() throws Exception {
        mockStudentManager = mock(StudentManager.class);
        Score score = new Score(2, 1, 1, 1);
        student = new Student("111","Tom",score);
        when(mockStudentManager.getStudentById("111")).thenReturn(student);
    }

    @Test
    public void get_empty_reports_when_input_no_student_id() throws Exception {
        //Given
        reports = new Reports(Arrays.asList());
        String emptyReports = new StringBuilder().append(reportsHeadTemplate).append(String.format(reportsTailTemplate,0.0,0)).toString();
        //When
        String  actual = reports.createReports();
        //Then
        assertEquals(emptyReports,actual);

    }

    @Test
    public void get_student_and_score_reports_when_input_one_student_id() throws Exception {
        //Given
        Reports.manager = mockStudentManager;
        reports = new Reports(Arrays.asList("111"));
        String expectReports = new StringBuilder()
                .append(reportsHeadTemplate)
                .append("Tom|2|1|1|1|1.25|5\n")
                .append(String.format(reportsTailTemplate,1.25,5)).toString();
        //When
        String actual = reports.createReports();
        //Then
        assertEquals(expectReports,actual);
    }
}
