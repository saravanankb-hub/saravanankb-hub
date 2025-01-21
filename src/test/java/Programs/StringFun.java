package Programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringFun {

    public static void printString(String str) {
        System.out.println("Given string: " + str);
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        String lowerCaseWord = str.toLowerCase();
        return IntStream.range(0, lowerCaseWord.length() / 2)
                .allMatch(i -> lowerCaseWord.charAt(i) == lowerCaseWord.charAt(lowerCaseWord.length() - 1 - i));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str1 = "Saravanan";
        String str2 = "saravanan";
        String str3 = new String("Saravanan");
        String str5 = new String("saravanan");
        String str4 = new String("saravanan");
        System.out.println(str1 == str2);//false Content matches (S vs s)
        System.out.println(str1 == str3);//false Created using new keywords refer diff obj even same content
        System.out.println(str1 == str4);//false same as above
        System.out.println(str3 == str4);//false content mismatch
        System.out.println(str2.equals(str4));//true address referring the same name
        System.out.println(str1.equals(str3));//true same as above
        System.out.println(str3.equals(str4));//false though address referring new. But content is not equal
        System.out.println(str4.equals(str5));//true content is equal
        System.out.println("------------------------------------------");
        String dummy = new String("Saravanan3new46many678many");//consecutive numbers will also considered as one split - empty string
        printString(dummy);
        String[] words = dummy.split("[^a-zA-Z]");
        System.out.println("Words count : " + words.length);//7
        for (String word : words) {
            System.out.print(" " + word);//Saravanan | new | many | many
        }
        //To fix the empty string
        int wordsCount = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                wordsCount++;
                System.out.print(" " + word);
            }
        }
        System.out.println("\nWords count : " + wordsCount);
        /*
        Words count : 7
        Saravanan new many many Saravanan new many many
        Words count : 4
        */
        System.out.println("------------------------------------------");
        printString(dummy);
        String onlyAlphs = dummy.replaceAll("[^a-zA-Z]", "");
        String onlyNums = dummy.replaceAll("[^0-9]", "");
        System.out.println("Only Alphabets: " + onlyAlphs + "\nAlphabets count:" + onlyAlphs.length() + "\nOnly Numbers: "
                + onlyNums + "\nNumbers count:" + onlyNums.length());
        /*
        Only Alphabets: Saravanannewmanymany
        Alphabets count:20
        Only Numbers: 346678
        Numbers count:6
        */
        System.out.println("------------------------------------------");
        printString(dummy);
        LinkedHashMap<Character, Integer> charMap = new LinkedHashMap<>();
        for (char c : dummy.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (HashMap.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue() + " time(s) | ");
        }
        //o/p-S: 1 time(s) | a: 6 time(s) | r: 1 time(s) | v: 1 time(s) | n: 5 time(s) | 3: 1 time(s) | e: 1 time(s) | w: 1 time(s) | 4: 1 time(s) | 6: 2 time(s) | m: 2 time(s) | y: 2 time(s) | 7: 1 time(s) | 8: 1 time(s) |
        System.out.println("\n------------------------------------------");
        String stmt = "My new laptop has got new keyboard skin to protect keys, that keeps my laptop more reliable";
        printString(stmt);
        LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();
        String[] strArr = stmt.split(" ");
        for (String word : strArr) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (HashMap.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > 1) { // to get the duplicate value
                System.out.print(entry.getKey() + ": " + entry.getValue() + " time(s) | ");
            }
        }
        //o/p - new: 2 time(s) | laptop: 2 time(s) |
        System.out.println("\n------------------------------------------");
        int[] arr1 = {3, 8, 11, 4, 6, 7};
        int[] arr2 = {1, 2, 8, 4, 9, 7};
        // Convert arr2 to a Set for O(1) lookups
        Set<Integer> arr2Set = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
        Arrays.stream(arr1)
                .filter(arr2Set::contains)
                .forEach(System.out::println);
        //o/p - 8 4 7
        System.out.println("\n------------------------------------------");
        String palin = "Racecar1";
        printString(palin);
        if (isPalindrome(palin)) {
            System.out.println(palin + " is a palindrome");
        } else {
            System.out.println(palin + " is not a palindrome");
        }
        isPalindrome("Racecar");
        System.out.println("\n------------------------------------------");
        String wordNew = "newhouseshouldbuy";
        printString(wordNew);
        char[] chArr = wordNew.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (i % 2 == 0) {
                System.out.print(Character.toUpperCase(chArr[i]));
            } else {
                System.out.print(chArr[i]);
            }
        }
        System.out.println("\n------------------------------------------");

    }
}