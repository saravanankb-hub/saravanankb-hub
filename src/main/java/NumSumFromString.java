import java.util.Arrays;

public class NumSumFromString {
    public static void main(String[] args) {
        String input = "abc123Def45+@#$1";
        int sum = 0;

        String[] parts = input.split("\\D+");//\\d+ gives only alphabets

//Using normal for loop
        for (String part : parts) {
            if (!part.isEmpty()) {
                sum += Integer.parseInt(part);
            }
        }
//Using Streams
        int sum1 = Arrays.stream(parts)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println("Sum of numbers: " + sum + "\nUsing Streams:" + sum1);
    }
}