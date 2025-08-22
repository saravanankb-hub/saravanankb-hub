package Programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortArrayString {

    public static void main(String[] args) {
        List<String> p = Arrays.asList("Bala", "Rajuree12", "Meenauu", "w");

//        p.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
//        p.sort(Comparator.comparing(String::length));

        String s = p.stream().findFirst().get();

        Map<String, Integer> map = Map.of(
                "Coffee", 4,
                "Ginger", 2,
                "Milk", 5,
                "Tea Powder", 1
        );

        System.out.println("Original: " + p + " :" + s);
//-------------------------------------------------------------------------
        Map<String, Integer> sortedByValue = map.entrySet()
                .stream()
//                .sorted(Map.Entry.comparingByValue()) -- Not required if merge function and Duplicate matter (While using List)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        sortedByValue.forEach((key, value) ->
                System.out.println(key + " :" + value));
    }
}