package Programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CharFrequency {
    public static void main(String[] args) {
        String input = "autuot";
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : input.replaceAll(" ", "").toLowerCase().toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        System.out.println(frequencyMap);  // Output: {a=1, t=2, u=2, o=1}

        Optional<Character> secondDup = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> frequencyMap.get(c) > 1)
                .distinct()  // avoid counting same char twice
                .skip(1) // skip the first duplicate
                .findFirst();
        System.out.println("Second duplicate character: " + secondDup.orElse(null)); //output : t
    }

    /*
    *  String cleanedInput = input.replaceAll(" ", "").toLowerCase();

        // Count frequency using for and if (no getOrDefault)
        for (char c : cleanedInput.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            } else {
                frequencyMap.put(c, 1);
            }
        }*/
}