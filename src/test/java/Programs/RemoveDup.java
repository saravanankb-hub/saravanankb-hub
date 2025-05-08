package Programs;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDup {

    public static void main(String[] args) {
        String input = "hello world";

        Set<Character> charSet = new LinkedHashSet<>();
        for (char c : input.toCharArray()) {
            charSet.add(c);
        }

        StringBuilder dupRemoved = new StringBuilder();
        for (Character c : charSet) {
            dupRemoved.append(c);
        }
        System.out.print("Before removing the duplicates: " + input + "\n");
        System.out.print("After removing the duplicates: " + dupRemoved);
    }
}