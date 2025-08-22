package Programs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeat {
    public static void main(String[] args) {
        String input = " stresst";
        Map<Character, Integer> map = new LinkedHashMap<>();

        String cleaned = input.replaceAll(" ", "");
        for (char c : cleaned.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeat charc:" + entry.getKey());  // Output: t
                break;
            }
        }
//second non-repeat
        Optional<Character> secondNonRepeat = cleaned.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> map.get(c) == 1)
                .distinct()
                .skip(1)
                .findFirst();
        System.out.println("Second non-repeat charc:" + secondNonRepeat.orElse(null));

        //---If it is int type---- int input=123245621;
//        Map<Character,Integer> map=new LinkedHashMap<>();
//        String refinedStr=String.valueOf(input); // need to use String.valueOf(str);
//        for(char c:refinedStr.toCharArray()){
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
    }
}