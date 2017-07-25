package frequencyWords;

import java.util.*;

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

    public LinkedHashMap<String,Integer> sortWords(HashMap<String, Integer> map) {
        LinkedHashMap<String,Integer> sortedWordsAndFrequency = new LinkedHashMap<>();

        List<Map.Entry<String, Integer>> infos = new ArrayList<>(map.entrySet());

        Collections.sort(infos, new Comparator<Map.Entry<String, Integer>>(){

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry:infos){

            sortedWordsAndFrequency.put(entry.getKey(), entry.getValue());

        }
        return sortedWordsAndFrequency;

    }

    public void printResult(LinkedHashMap<String, Integer> map) {

        for(Map.Entry<String, Integer> entry:map.entrySet()){

            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }
}
