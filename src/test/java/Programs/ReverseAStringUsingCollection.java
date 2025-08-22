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

        /* Traditional for-if
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("Reversed string: " + reversed);
         */
// for Reversing each word. then add one more for and initialize one more string inside for and append then append into main
//        string result.
        String input = "madam";//3:0
        StringBuilder rev = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            rev.append(input.charAt(i));
        }
        if (rev.toString().equalsIgnoreCase(input)) {
            System.out.println("Using string : Palindrome");
        } else {
            System.out.println("Using string : Not a Palindrome");
        }

        String input1 = "madam"; // Expected output: Palindrome

        StringBuilder sb = new StringBuilder(input);
        String reversed1 = sb.reverse().toString();

        if (input1.equals(reversed1)) {
            System.out.println("Using string Builder: Palindrome");
        } else {
            System.out.println("Using string Builder: Not a Palindrome");
        }
    }

}