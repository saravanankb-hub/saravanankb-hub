package Programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupResults {
    public static void main(String[] args) {
        List<String> testResults = Arrays.asList("PASS", "FAIL", "PASS", "SKIP", "FAIL");

        Map<String, Long> counts = testResults.stream()
                .collect(
                        Collectors.groupingBy(
                                result -> result, Collectors.counting()
                        )
                );

        System.out.println(counts);  // Output: {PASS=2, FAIL=2, SKIP=1}
    }
}