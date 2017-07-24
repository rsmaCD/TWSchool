package practice_1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class PersonTest {

    private Person person;

    @Test
    public void testIntroduce() throws Exception {
        person = new Person("Tom", 21);
        assertEquals(person.introduce(),"My name is Tom. I am 21 years old.");
    }

    @Test
    public void testModifyName() throws Exception {
        person = new Person("Tom",21);
        person.setName("Tom Wu");
        assertEquals(person.introduce(),"My name is Tom Wu. I am 21 years old.");
    }

}
