package practice_6;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 24/07/2017.
 */
public class WorkerTest {
    @Test
    public void testIntroduce() throws Exception {
        Worker worker = new Worker("Tom", 21);
        assertEquals(worker.introduce(),"My name is Tom. I am 21 years old. I am a Worker. I have a job.");
    }
}
