package practice_9;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class KClassTest {

    private KClass kClass;

    @Test
    public void testGetNum() throws Exception {
        kClass = new KClass(2);
        assertEquals(kClass.getClassNum(),2);
    }

    @Test
    public void testAssignLeader() throws Exception {
        kClass = new KClass(2);
        Student student = new Student("111","Tom", 21,kClass);
        kClass.assignLeader(student);

        assertEquals(kClass.getLeader(),student);
    }
}
