package Programs;

import java.util.HashMap;
import java.util.Map;

public class CharFrequency {
    public static void main(String[] args) {
        String input = "automate There";
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : input.replaceAll(" ", "").toLowerCase().toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        System.out.println(frequencyMap);  // Output: {a=2, r=1, t=3, u=1, e=3, h=1, m=1, o=1}
    }
}