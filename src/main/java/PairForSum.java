import java.util.HashSet;
import java.util.Set;

public class PairForSum {
    // To find the pair whose sum should be equal to the given number

    public static void main(String[] args) {
        int sum = 20;
        int[] arr = {2, 5, 4, 3, 17, 15, 1, 5};

        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = sum - num;
            //20-2 = 18 ->not in Set(seen) so add in SET  = {2}
            //20-5 = 15 -> not in Set(seen) so add in SET = {2,5}
            //20-4 = 16 -> not in Set(seen) so add in SET = {2,5,4}
            //20-3 = 17 -> not in Set(seen) so add 3 in SET = {2,5,4,3}
            //20-17 = 3 is in Set(seen) so no change in SET = {2,5,4,3} -> Pair {17,3}
            //20-15 = 5 is in Set(seen) so no change in SET = {2,5,4,3} -> Pair {15,5}
            //20-1 = 19 -> not in Set(seen) so add 1 in SET = {2,5,4,3,1}
            //20-5 = 15 is in Set(seen) so no change in SET = {2,5,4,3,1} -> Pair {5,15}

            if (seen.contains(complement)) {
                System.out.println("Pair: " + num + " and " + complement + " = " + sum);
            }
            seen.add(num);
        }
    }
}