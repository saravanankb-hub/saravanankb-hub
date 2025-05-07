package Programs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByMapValue {

    public static void main(String[] args) {
        Map<String, Integer> unsorted = Map.of("A", 3, "B", 1, "C", 2);

        LinkedHashMap<String, Integer> sorted = unsorted.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));

        System.out.println(sorted);  // Output: {B=1, C=2, A=3}
    }
}