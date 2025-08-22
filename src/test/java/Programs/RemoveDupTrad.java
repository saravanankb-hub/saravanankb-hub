package Programs;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDupTrad {

    public static void main(String[] args) {
        String input = "hello world";
        /// Need correction
//        StringBuilder newStr = new StringBuilder();
//        for (int i = 0; i < input.length(); i++) {
//            for (int j = 1; j <= input.length() - i; j++) { //1>0   2>1 1>1  3>2 3>2 3>1
//                if (input.charAt(i) != input.charAt(j)) {
//                    newStr.append(input.charAt(i));
//                }
//            }
//        }
//        System.out.print(newStr);

        //using getOrDefault
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey());
        }
    }
}