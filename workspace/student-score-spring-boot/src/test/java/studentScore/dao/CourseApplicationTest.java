package studentScore.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import studentScore.entity.Course;

/**
 * Created by rsma on 10/08/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseApplicationTest {
    @Autowired
    private CourseRepository courseRepository;

    @Before
    public void setUp() throws Exception {
        courseRepository.save(new Course("math",80));
        courseRepository.save(new Course("english",81));
        courseRepository.save(new Course("language",82));
        courseRepository.save(new Course("program",83));
    }

    @Test
    public void should_get_course_which_course_name_is_math() throws Exception {
        Course math = courseRepository.findByCourseName("math");
        Assert.assertEquals(80, math.getCourseScore());
    }
}
