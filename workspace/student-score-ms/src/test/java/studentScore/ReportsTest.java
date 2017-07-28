package studentScore;

import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setUp() throws Exception {
        mockStudentManager = mock(StudentManager.class);
        reports = new Reports(mockStudentManager);

        Score score1 = new Score(2, 1, 1, 1);
        Student tom = new Student("111","Tom",score1);
        when(mockStudentManager.getStudentById("111")).thenReturn(tom);

        Score score2 = new Score(2, 2, 2, 2);
        Student lili = new Student("110","Lili",score2);
        when(mockStudentManager.getStudentById("110")).thenReturn(lili);

        Score score23 = new Score(2, 2, 2, 2);
        Student www = new Student("112","WWW",score2);
        when(mockStudentManager.getStudentById("112")).thenReturn(www);
    }

    @Test
    public void get_empty_reports_when_input_no_student_id() throws Exception {
        //Given
        reports = new Reports();
        String emptyReports = new StringBuilder().append(Global.reportsHeadTemplate).append(String.format(Global.reportsTailTemplate,0.0,0.0)).toString();
        //When
        String  actual = reports.createReports(Arrays.asList());
        //Then
        assertEquals(emptyReports,actual);

    }

    @Test
    public void get_student_and_score_reports_when_input_one_student_id() throws Exception {
        //Given
        reports = new Reports();
        String expectReports = new StringBuilder()
                .append(Global.reportsHeadTemplate)
                .append("Tom|2|1|1|1|1.25|5\n")
                .append(String.format(Global.reportsTailTemplate,1.25,5.0)).toString();
        //When
        String actual = reports.createReports(Arrays.asList("111"));
        //Then
        assertEquals(expectReports,actual);
    }

    @Test
    public void get_students_and_score_reports_when_input_two_students_id() throws Exception {
        //Given
        reports = new Reports();
        String expectReports = new StringBuilder()
                .append(Global.reportsHeadTemplate)
                .append("Tom|2|1|1|1|1.25|5\n")
                .append("Lili|2|2|2|2|2.00|8\n")
                .append(String.format(Global.reportsTailTemplate,1.625,6.5)).toString();
        //When
        String actual = reports.createReports(Arrays.asList("111","110"));
        //Then
        assertEquals(expectReports,actual);
    }

    @Test
    public void get_students_and_score_reports_when_input_Three_students_id() throws Exception {
        //Given
        reports = new Reports();
        String expectReports = new StringBuilder()
                .append(Global.reportsHeadTemplate)
                .append("Tom|2|1|1|1|1.25|5\n")
                .append("Lili|2|2|2|2|2.00|8\n")
                .append("WWW|2|2|2|2|2.00|8\n")
                .append(String.format(Global.reportsTailTemplate,1.75,8.0)).toString();
        //When
        String actual = reports.createReports(Arrays.asList("111","110","112"));
        //Then
        assertEquals(expectReports,actual);
    }
}
