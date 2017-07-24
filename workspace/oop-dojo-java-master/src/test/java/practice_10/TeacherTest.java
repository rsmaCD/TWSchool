package practice_10;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class TeacherTest {

    private KClass kclass;

    @Test
    public void testIntroduce() throws Exception {
        kclass = new KClass(3);
        Teacher teacher = new Teacher("111","Tom", 21, kclass);
        assertEquals(teacher.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach Class 3.");

        Teacher teacher1 = new Teacher("110","Tom",21);
        assertEquals(teacher1.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.");
    }
}
