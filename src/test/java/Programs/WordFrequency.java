package Programs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {

        String[] strArr = {"pomo", "apple", "orange", "pomo", "apple"};
//        List<String> words = Arrays.asList(strArr); not required but if keep no issues

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word : strArr) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.print(map);

        List<String> dupList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                dupList.add(entry.getKey());
            }
        }
        System.out.print(dupList);
    }
}