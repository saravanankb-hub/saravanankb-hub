package Programs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {

        String[] strArr = {"pomo", "apple", "orange", "pomo", "apple"};
        List<String> words = Arrays.asList(strArr);

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.print(map);
    }
}