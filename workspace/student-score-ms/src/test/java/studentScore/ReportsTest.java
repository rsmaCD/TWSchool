package studentScore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 26/07/2017.
 */
public class ReportsTest {

    private Reports reports;
    private Student tom;
    private Student lili;
    private Student www;

    @Before
    public void setUp() throws Exception {
        Course mathCourse = new Course(Global.mathCourseName,2);
        Course languageCourse = new Course(Global.languageCourseName,1);
        Course englishCourse = new Course(Global.englishCourseName,1);
        Course programCourse = new Course(Global.programCourseName,1);
        List<Course> courseList = asList(mathCourse,languageCourse,englishCourse,programCourse);

        tom = new Student("111","Tom",courseList);

        mathCourse = new Course(Global.mathCourseName,2);
        languageCourse = new Course(Global.languageCourseName,2);
        englishCourse = new Course(Global.englishCourseName,2);
        programCourse = new Course(Global.programCourseName,2);
        courseList = asList(mathCourse,languageCourse,englishCourse,programCourse);

        lili = new Student("112", "Lili", courseList);

        www = new Student("113", "WWW", courseList);


    }

    @Test
    public void get_empty_reports_when_input_no_student_id() throws Exception {
        //Given
        reports = new Reports();
        String emptyReports = new StringBuilder().append(Global.reportsHeadTemplate).append(String.format(Global.reportsTailTemplate,0.0,0.0)).toString();
        //When
        String  actual = reports.createReports(asList());
        //Then
        assertEquals(emptyReports,actual);

    }

    @Test
    public void get_student_and_score_reports_when_input_one_student() throws Exception {
        //Given
        reports = new Reports();
        String expectReports = new StringBuilder()
                .append(Global.reportsHeadTemplate)
                .append("Tom|2|1|1|1|1.25|5\n")
                .append(String.format(Global.reportsTailTemplate,1.25,5.0)).toString();

        //When
        String actual = reports.createReports(asList(tom));
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
        String actual = reports.createReports(asList(tom,lili));
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
        String actual = reports.createReports(asList(tom,lili,www));
        //Then
        assertEquals(expectReports,actual);
    }
}
