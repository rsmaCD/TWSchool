package practice_12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class KClassTest{

    private KClass kClass;
    private Student student;

    @Test
    public void testGetNum() throws Exception {
        kClass = new KClass(2);
        assertEquals(kClass.getClassNum(),2);
    }

    @Test
    public void testAssignLeaderSuccess() throws Exception {
        kClass = new KClass(2);
        student = new Student("111","Tom", 21,kClass);
        kClass.assignLeader(student);

        assertEquals(kClass.getLeader(), student);
    }

    @Test
    public void testAppendMerber() throws Exception {
        kClass = new KClass(2);
        student = new Student("111","Tom",21);
        kClass.appendMember(student);

        assertEquals(student.getKClass(), kClass);
    }

    @Test
    public void testAssignLeaderFail() throws Exception {
        kClass = new KClass(2);
        student = new Student("111","Tom",21);
        kClass.assignLeader(student);

        assertEquals(outContent.toString(),"It is not one of us.");
    }

    @Test
    public void testInformTeacher1() throws Exception {
        kClass = new KClass(2);
        student = new Student("111","Jerry",21);
        Teacher teacher = new Teacher("110","Tom",21, Arrays.asList(new KClass[]{kClass}));
        kClass.appendMember(student);

        assertEquals(outContent.toString(),"I am Tom. I know Jerry has joined Class 2.");
    }

    @Test
    public void testInformTeacher2() throws Exception {
        kClass = new KClass(2);
        student = new Student("111","Jerry",21,kClass);
        Teacher teacher = new Teacher("110","Tom",21, Arrays.asList(new KClass[]{kClass}));
        kClass.assignLeader(student);

        assertEquals(outContent.toString(),"I am Tom. I know Jerry become Leader of Class 2.");
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
