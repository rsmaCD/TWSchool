package practice_8;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class StudentTest {
    @Test
    public void testIntroduce() throws Exception {
        KClass kclass = new KClass(2);
        Student student = new Student("Tom", 21,kclass);
        assertEquals(student.introduce(),"My name is Tom. I am 21 years old. I am a Student. I am at Class 2.");
    }
}
