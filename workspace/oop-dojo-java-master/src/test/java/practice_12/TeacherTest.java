package practice_12;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class TeacherTest {

    @Test
    public void testIntroduce() throws Exception {
        KClass kclass1 = new KClass(1);
        KClass kclass2 = new KClass(2);
        Teacher teacher = new Teacher("111","Tom", 21, Arrays.asList(new KClass[]{kclass1,kclass2}));
        assertEquals(teacher.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach Class 1, 2.");

        Teacher teacher1 = new Teacher("110","Tom",21);
        assertEquals(teacher1.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.");
    }

    @Test
    public void testIsTeaching() throws Exception {

        KClass kClass1 = new KClass(1);
        KClass kClass2 = new KClass(2);
        KClass kClass3 = new KClass(3);
        Teacher teacher = new Teacher("111","Tom",21,Arrays.asList(new KClass[]{kClass1,kClass2}));
        Student student1 = new Student("110","Jerry",21,kClass2);
        Student student2 = new Student("112","Jerry",21,kClass3);

        assertEquals(teacher.isTeaching(student1),true);
        assertEquals(teacher.isTeaching(student2),false);

    }
}
