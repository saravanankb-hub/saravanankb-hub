package Programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEven {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> even = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> evenTrad = new ArrayList<>();
        System.out.println(even);  // Output: [2, 4, 6]

        //Traditional mtd
        for (Integer num : nums) {
            if (num % 2 == 0)
                evenTrad.add(num);
        }
        System.out.println("Using Traditional mtd:" + evenTrad);
        System.out.println("Using stream :" + even);
    }
}