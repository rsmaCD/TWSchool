package studentScore.service;

import org.junit.Before;
import org.junit.Test;
import studentScore.entity.Course;
import studentScore.entity.Student;
import studentScore.global.Global;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentScoreServiceTest {

    private StudentManager mockStudentManager;
    private ReportsService mockReports;
    private StudentScoreService studentScoreSystem;
    private List<Course> courseListLegal;
    private Student tom;
    private Student lili;

    @Before
    public void setUp() throws Exception {

        mockStudentManager = mock(StudentManager.class);
        mockReports = mock(ReportsService.class);
        studentScoreSystem = new StudentScoreService(mockStudentManager,mockReports);

        Course mathCourse = new Course(Global.mathCourseName,2);
        Course languageCourse = new Course(Global.languageCourseName,2);
        Course englishCourse = new Course(Global.englishCourseName,2);
        Course programCourse = new Course(Global.programCourseName,2);
        courseListLegal = asList(mathCourse,languageCourse,englishCourse,programCourse);

        tom = new Student("111","Tom",courseListLegal);
        lili = new Student("110","Lili",courseListLegal);

        when(mockStudentManager.getStudentsByIdList(asList("110","111"))).thenReturn(asList(tom, lili));
    }

    @Test
    public void should_call_creatstudent_onece_when_input_legal() throws Exception {
        studentScoreSystem.createStudent("Tom,112,2,2,2,2");
        verify(mockStudentManager, times(1)).postStudent(new Student("112","Tom",courseListLegal));
    }

    @Test
    public void should_call_creatreports_once__When_input_legal() throws Exception {

        studentScoreSystem.createReports("110,111");
        verify(mockStudentManager, times(1)).getStudentsByIdList(asList("110","111"));
        verify(mockReports, times(1)).createReportsWithTemplate(asList(tom,lili));

    }
}
