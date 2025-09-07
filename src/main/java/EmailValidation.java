import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String emailRegex = "^[a-zA-z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-z]{2,}$";
        System.out.print("Enter the email address:");

        String email = scanner.nextLine();
        //Compile regex
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println(email + " is a valid Email address");
        } else {
            System.out.println(email + " is not a valid Email address");
        }

        scanner.close();
    }
}