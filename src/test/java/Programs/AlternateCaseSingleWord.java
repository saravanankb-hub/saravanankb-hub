package Programs;

public class AlternateCaseSingleWord {
    public static void main(String[] args) {
        String input = "neon";
        String result = "";

        for (int i = 0; i < input.toLowerCase().length(); i++) {
            char ch = input.charAt(i);
            if (i % 2 == 0) {
                result += Character.toUpperCase(ch);
            } else {
                result += ch;
            }
        }

        System.out.println(result);  // Output: NeOn
    }
}