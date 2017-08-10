package studentScore.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import studentScore.entity.Course;
import studentScore.entity.Student;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Created by rsma on 10/08/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplicationTest {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Before
    public void setUp() throws Exception {

        Student student = new Student("tom","idCardNum","e-mail","phoneNum","nativePlace");
        Course math = new Course("math",80,student);
        Course english = new Course("english",81,student);
        Course language = new Course("language",82,student);
        Course program = new Course("program",83,student);
        List<Course> courseList = asList(math,english,language,program);

        student.setCourseList(courseList);
        studentRepository.save(student);

    }

    @Test
    public void should_get_course_80() throws Exception {
        Student tom = studentRepository.findByName("tom");
        Course math1 = tom.getCourseList()
                .stream()
                .filter(course -> course.getCourseName().equals("math"))
                .findFirst().get();
        Assert.assertEquals(80, math1.getCourseScore());
    }
}
