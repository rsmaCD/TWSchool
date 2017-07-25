package practice_13;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class StudentTest {

    private KClass kclass;
    private Student student;

    @Test
    public void should_get_student_introduce() throws Exception {
        kclass = new KClass(2);
        student = new Student("111","Tom", 21, kclass);
        assertEquals(student.introduce(),"My name is Tom. I am 21 years old. I am a Student. I am at Class 2.");
    }


    @Test
    public void should_get_leader_student_introduce() throws Exception {
        kclass = new KClass(2);
        student = new Student("110","Tom", 21, kclass);

        kclass.assignLeader(student);
        assertEquals(student.introduce(),"My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.");

    }
}
