package Programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDupUsingSet {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("Selenium", "Java", "Selenium", "TestNG");
        Set<String> unique = new HashSet<>(items);
        System.out.println(unique);  // Output: [Java, Selenium, TestNG] (Order not guaranteed)
    }
}