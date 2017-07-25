package frequencyWords;

import java.io.*;
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

    public List<String> readFileTxt(String filePath) {
        List<String> readResult = new ArrayList<>();
        String encoding="GBK";
        try {
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(filePath),encoding);//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
                readResult.add(lineTxt);
            }
            read.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return readResult;
    }


    public void printSortedWordsAndFrequencyInFile(String filePath) {

        List<String> fileContent = readFileTxt(filePath);
        LinkedHashMap<String, Integer> sortedWordsAndFrequency = getSortedWordsAndFrequency(fileContent);
        printResult(sortedWordsAndFrequency);
    }

    private LinkedHashMap<String,Integer> getSortedWordsAndFrequency(List<String> fileContent) {
        List<String> wordsList = new ArrayList<>();
        for (String fileLine : fileContent) {
            wordsList.addAll(splitStr(fileLine));
        }

        LinkedHashMap<String,Integer> sortedWords = sortWords(countWords(wordsList));
        return sortedWords;
    }
}
