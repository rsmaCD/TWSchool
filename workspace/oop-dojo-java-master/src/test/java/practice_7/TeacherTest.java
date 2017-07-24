package practice_7;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class TeacherTest {
    @Test
    public void testIntroduce() throws Exception {
        Teacher teacher = new Teacher("Tom", 21,2);
        assertEquals(teacher.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.");

        Teacher teacher1 = new Teacher("Tom",21);
        assertEquals(teacher1.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.");
    }
}
