package frequencyWords;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;

/**
 * Created by rsma on 25/07/2017.
 */
public class FrequencyWordsTest {

    private List<String> strList;
    private FrequencyWords frequencyWords;
    private HashMap<String, Integer> hashMap;
    private Map<String,Integer> sortedWordsAndFrequency;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


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
        assertEquals(hashMap,exceptHashMap);
    }

    @Before
    public void setUp() throws Exception {
        hashMap = new HashMap<>();
        hashMap.put("a",2);
        hashMap.put("the",1);
        hashMap.put("nihao",1);
        hashMap.put("kk",1);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_get_sorted_words_and_frequency_when_call_sortwords() throws Exception {
        //Given
        frequencyWords = new FrequencyWords();
        //When
        Map<String,Integer> exceptHashMap = frequencyWords.sortWords(hashMap);
        //Then
        Map<String,Integer> actualHashMap = new LinkedHashMap<>();
        actualHashMap.put("a",2);
        actualHashMap.put("the",1);
        actualHashMap.put("nihao",1);
        actualHashMap.put("kk",1);
        assertEquals(actualHashMap,exceptHashMap);
    }


}
