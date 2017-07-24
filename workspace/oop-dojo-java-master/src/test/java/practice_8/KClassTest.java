package practice_8;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class KClassTest {
    @Test
    public void testGetNum() throws Exception {
        KClass aClass = new KClass(2);
        assertEquals(aClass.getClassNum(),2);
    }
}
