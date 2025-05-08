package Programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseAStringUsingCollection {

    public static void main(String[] args) {

        String str = "New String";
        List<Character> charList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            charList.add(c);
        }

        Collections.reverse(charList);

        StringBuilder reversed = new StringBuilder();
        for (char c : charList) {
            reversed.append(c);
        }
        System.out.print(reversed);

    }

}