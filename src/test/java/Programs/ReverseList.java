package Programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseList {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Darwin", "Charlie");
        Collections.reverse(names);
        System.out.println(names);  // Output: [Charlie, Bob, Alice]
    }

}