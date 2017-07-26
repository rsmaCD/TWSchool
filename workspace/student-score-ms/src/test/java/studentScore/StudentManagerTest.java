package studentScore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentManagerTest {

    private StudentManager manager;

    @After
    public void tearDown() throws Exception {
        manager.cleanList();
    }

    @Test
    public void should_get_true_when_create_student() throws Exception {
        //Given
        manager = StudentManager.getInstance();
        Score score = new Score(2, 1, 1, 1);
        //When
        boolean actual = manager.createStudent("111","Tom",score);
        //Then
        assertEquals(true,actual);
    }

    @Test
    public void should_get_false_when_create_same_id_student() throws Exception {
        //Given
        manager = StudentManager.getInstance();
        Score score = new Score(2, 1, 1, 1);
        //When
        manager.createStudent("111","Tom",score);
        boolean actual = manager.createStudent("111","Lili",score);
        //Then
        assertEquals(false,actual);
    }

    @Test
    public void should_get_student_when_find_exist_student() throws Exception {
        //Given
        manager = StudentManager.getInstance();
        Score score = new Score(2, 1, 1, 1);
        Student expectedStudent = new Student("111", "Tom", score);
        //When
        manager.createStudent("111","Tom",score);
        Student actualStudent = manager.getStudentById("111");
        //Then
        assertEquals(expectedStudent,actualStudent);
    }

    @Test
    public void should_get_null_when_find_not_exist_student() throws Exception {
        //Given
        manager = StudentManager.getInstance();
        Score score = new Score(2, 1, 1, 1);
        //When
        Student actualStudent = manager.getStudentById("111");
        //Then
        assertEquals(null,actualStudent);
    }
}
