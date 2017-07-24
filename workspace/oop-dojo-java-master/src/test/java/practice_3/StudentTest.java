package practice_3;

import org.junit.Test;
import practice_2.Student;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class StudentTest {

    @Test
    public void testIntroduce() throws Exception {
        practice_2.Student student = new Student("Tom", 21, 2);
        assertEquals(student.introduce(),"My name is Tom. I am 21 years old. I am a Student. I am at Class 2.");
    }
}
