package Programs;

public class AlternateCaseSingleWord {
    public static void main(String[] args) {
        String input = "neon";
        String result = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (i % 2 == 0) {
                result += Character.toLowerCase(ch);
            } else {
                result += Character.toUpperCase(ch);
            }
        }

        System.out.println(result);  // Output: nEoN
    }
}