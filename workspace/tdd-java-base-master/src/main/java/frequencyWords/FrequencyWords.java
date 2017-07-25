package frequencyWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rsma on 25/07/2017.
 */
public class FrequencyWords {

    public List<String> splitStr(String str) {

        List<String> strList = new ArrayList<>();
        String[] strArr = str.split(" ");
        for (String strTemp:strArr) {
            if(!strTemp.trim().isEmpty()) {
                strList.add(strTemp.trim());
            }
        }
        return strList;
    }

    public HashMap<String,Integer> countWords(List<String> strList) {

        HashMap<String,Integer> wordsAndFrequency = new HashMap<>();
        for (String strTemp : strList) {
            if(wordsAndFrequency.containsKey(strTemp)){
                int value = wordsAndFrequency.get(strTemp);
                wordsAndFrequency.put(strTemp,value + 1);
            }else {
                wordsAndFrequency.put(strTemp,1);
            }
        }

        return wordsAndFrequency;
    }
}
