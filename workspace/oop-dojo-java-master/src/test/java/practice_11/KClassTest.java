package practice_11;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class KClassTest {

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
