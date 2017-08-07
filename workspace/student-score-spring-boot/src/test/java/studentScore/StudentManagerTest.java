package studentScore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import studentScore.entity.Course;
import studentScore.entity.Student;
import studentScore.entity.StudentManager;
import studentScore.global.Global;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentManagerTest {

    private StudentManager manager;
    private Course mathCourse;
    private Course languageCourse;
    private Course englishCourse;
    private Course programCourse;
    private List<Course> courseList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        mathCourse = new Course(Global.mathCourseName,1);
        languageCourse = new Course(Global.languageCourseName,1);
        englishCourse = new Course(Global.englishCourseName,1);
        programCourse = new Course(Global.programCourseName,1);
        courseList = asList(mathCourse,languageCourse,englishCourse,programCourse);
    }

    @After
    public void tearDown() throws Exception {
        manager.cleanList();
    }

    @Test
    public void should_get_true_when_create_student() throws Exception {
        //Given
        manager = StudentManager.getInstance();
        //When
        Student student = manager.createStudent("111"
                ,"Tom"
                ,courseList);
        //Then
        assertEquals(true,student != null);
    }

    @Test
    public void should_get_false_when_create_same_id_student() throws Exception {
        //Given
        manager = StudentManager.getInstance();
        //When
        manager.createStudent("111","Tom",courseList);
        Student student = manager.createStudent("111","Lili",courseList);
        //Then
        assertEquals(false,student != null);
    }

    @Test
    public void should_get_student_when_find_exist_student() throws Exception {
        //Given
        manager = StudentManager.getInstance();
        Student expectedStudent = new Student("111", "Tom", courseList);
        //When
        manager.createStudent("111","Tom",courseList);
        Student actualStudent = manager.getStudentById("111");
        //Then
        assertEquals(expectedStudent,actualStudent);
    }

    @Test
    public void should_get_null_when_find_not_exist_student() throws Exception {
        //Given
        manager = StudentManager.getInstance();
        //When
        Student actualStudent = manager.getStudentById("111");
        //Then
        assertEquals(null,actualStudent);
    }
}
