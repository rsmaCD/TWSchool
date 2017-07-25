package frequencyWords;

import java.util.ArrayList;
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
}
