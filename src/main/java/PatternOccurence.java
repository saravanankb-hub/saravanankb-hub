public class PatternOccurence {

    public static void main(String[] args) {
        String input = "sara2q23ertysara2ytsarac";
        String pattern = "sarav";

        int index = 0, count = 0;
        while ((index = input.indexOf(pattern, index)) != -1) {
            count++;
            index = index + pattern.length();
        }

        if (count > 1) {
            System.out.println("Pattern " + pattern + " appears " + count + " times");
        } else {
            System.out.println("Pattern " + pattern + " doesn't appear more than once");
        }
    }
}