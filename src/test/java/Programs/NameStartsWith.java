package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameStartsWith {

    public static void main(String args[]) {
        List<String> list = Arrays.asList("Jeeva", "Jacklin", "Hacker", "Yolker", "Jambo", "Ashok");
        List<String> filteredNames = list.stream().filter(
                        name -> name.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println(filteredNames);//[Jeeva, Jacklin, Jambo]

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> modifiedNums = nums.stream().map(n -> n * 4)
                .collect(Collectors.toList());
        System.out.println(modifiedNums);//[4, 8, 12, 16, 20]
    }
}