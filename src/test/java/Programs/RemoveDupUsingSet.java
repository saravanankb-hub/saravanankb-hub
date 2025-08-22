package Programs;

import java.util.*;

public class RemoveDupUsingSet {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("Selenium", "Java", "Selenium", "TestNG");
        Set<String> unique = new HashSet<>(items);
        System.out.println(unique);  // Output: [Java, Selenium, TestNG] (Order not guaranteed)


        /* Using getorDefault + to normal print*/
        Map<String, Integer> freqMap = new HashMap<>();

        for (String s : items) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }
        System.out.println(freqMap);

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}