package frequencyWords;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;

/**
 * Created by rsma on 25/07/2017.
 */
public class FrequencyWordsTest {

    @Test
    public void should_get_string_list_when_call_splitstring() throws Exception {
        //Given
        String str = "a the a nihao  kk";
        FrequencyWords frequencyWords = new FrequencyWords();
        //When
        List<String> actualList = frequencyWords.splitStr(str);
        //Then
        List<String> strList = Arrays.asList("a","the","a","nihao","kk");
        assertEquals(actualList,strList);
    }
}
