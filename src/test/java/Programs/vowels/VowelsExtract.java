package Programs.vowels;

public class VowelsExtract {

    public static void main(String[] args) {
        String str = "vowels here!";
        VowelsResult result = extractVowels(str);
        System.out.println("Vowels in the statement: " + result.vowels);
        System.out.println("Count of Vowels in the statement: " + result.count);

    }

    public static VowelsResult extractVowels(String input) {
        StringBuilder vowels = new StringBuilder();
        String lowerCaseStmt = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char c = lowerCaseStmt.charAt(i);
            if (c == 'o' || c == 'e' || c == 'i' || c == 'a' || c == 'u') {
                vowels.append(c);
            }
        }
        return new VowelsResult(vowels.toString(), vowels.length());
        //Here to we need to return 2 values but java can return ly one type at a time so declare class with Constructor
        // there using this refer the current instances.
        //return type here is calling that class so, we can pass 2 args now. (vowels and count)
    }
}