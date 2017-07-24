package practice_8;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class TeacherTest {
    @Test
    public void testIntroduce() throws Exception {
        KClass kclass = new KClass(2);
        Teacher teacher = new Teacher("Tom", 21, kclass);
        assertEquals(teacher.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.");

        Teacher teacher1 = new Teacher("Tom",21);
        assertEquals(teacher1.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.");
    }
}
