package frequencyWords;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;

/**
 * Created by rsma on 25/07/2017.
 */
public class FrequencyWordsTest {

    private List<String> strList;
    private FrequencyWords frequencyWords;

    @Test
    public void should_get_string_list_when_call_splitstring() throws Exception {
        //Given
        String str = "a the a nihao  kk";
        frequencyWords = new FrequencyWords();
        //When
        List<String> exceptList = frequencyWords.splitStr(str);
        //Then
        strList = Arrays.asList("a","the","a","nihao","kk");
        assertEquals(strList, exceptList);
    }

    @Test
    public void should_get_words_and_frequency_when_call_countwords() throws Exception {
        //Given
        strList = Arrays.asList("a","the","a","nihao","kk");
        frequencyWords = new FrequencyWords();
        //When
        HashMap<String,Integer> exceptHashMap = frequencyWords.countWords(strList);
        //Then
        HashMap<String,Integer> actualHashMap = new HashMap<>();
        actualHashMap.put("a",2);
        actualHashMap.put("the",1);
        actualHashMap.put("nihao",1);
        actualHashMap.put("kk",1);
        assertEquals(actualHashMap,exceptHashMap);
    }
}
