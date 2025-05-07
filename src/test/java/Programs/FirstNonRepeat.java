package Programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeat {
    public static void main(String[] args) {
        String input = " stress";
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : input.replaceAll(" ", "").toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());  // Output: t
                break;
            }
        }
    }
}