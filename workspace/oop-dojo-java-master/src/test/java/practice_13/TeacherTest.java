package practice_13;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class TeacherTest {

    private Teacher teacher;

    @Test
    public void should_get_teacher_introduce_when_teach_no_class() throws Exception {
        teacher = new Teacher("110","Tom",21);
        assertEquals(teacher.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.");
    }

    @Test
    public void should_get_teacher_introduce_when_teach_one_class() throws Exception {
        KClass kClass = new KClass(1);
        teacher = new Teacher("111","Tom", 21, Arrays.asList(new KClass[]{kClass}));
        assertEquals(teacher.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach Class 1.");
    }

    @Test
    public void should_get_teacher_introduce_when_teach_multi_class() throws Exception {
        KClass kclass1 = new KClass(1);
        KClass kclass2 = new KClass(2);
        teacher = new Teacher("111","Tom", 21, Arrays.asList(new KClass[]{kclass1,kclass2}));
        assertEquals(teacher.introduce(),"My name is Tom. I am 21 years old. I am a Teacher. I teach Class 1, 2.");
    }

    @Test
    public void should_return_true_when_teacher_is_teachering_student() throws Exception {

        KClass kClass1 = new KClass(1);
        KClass kClass2 = new KClass(2);
        teacher = new Teacher("111","Tom",21,Arrays.asList(new KClass[]{kClass1,kClass2}));
        Student student = new Student("110","Jerry",21,kClass2);

        assertEquals(teacher.isTeaching(student),true);

    }

    @Test
    public void should_return_false_when_teacher_is_not_teachering_student() throws Exception {

        KClass kClass1 = new KClass(1);
        KClass kClass2 = new KClass(2);
        KClass kClass3 = new KClass(3);
        Teacher teacher = new Teacher("111","Tom",21,Arrays.asList(new KClass[]{kClass1,kClass2}));
        Student student = new Student("112","Jerry",21,kClass3);

        assertEquals(teacher.isTeaching(student),false);

    }
}
