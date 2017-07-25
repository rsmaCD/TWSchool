package practice_13;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class PersonTest {
    @Test
    public void should_get_person_introduce() throws Exception {
        Person person = new Person("111","Tom", 21);
        assertEquals(person.introduce(),"My name is Tom. I am 21 years old.");
    }
}
