package practice_5;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class PersonTest {
    @Test
    public void testIntroduce() throws Exception {
        Person person = new Person("Tom", 21);
        assertEquals(person.introduce(),"My name is Tom. I am 21 years old.");
    }
}
