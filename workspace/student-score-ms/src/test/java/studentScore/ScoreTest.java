package studentScore;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by rsma on 26/07/2017.
 */
public class ScoreTest {

    private DecimalFormat df;
    private Score score;

    @Before
    public void setUp() throws Exception {
        df = new DecimalFormat("#.#");
        score = new Score(3, 1, 1, 1);
    }

    @Test
    public void get_average_score_when_call_getaveragescore() throws Exception {
        //Given
        //When
        double averageScore = score.getAverageScore();
        //Then
        assertEquals("1.5",df.format(averageScore));
    }

    @Test
    public void get_total_score_when_call_gettotalscore() throws Exception {
        //Given
        //When
        int totalScore = score.getTotalScore();
        //Then
        assertEquals(6,totalScore);
    }
}
