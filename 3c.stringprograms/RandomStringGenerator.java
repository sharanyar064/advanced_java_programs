// Q: How can we create a random string of a specified length using a user-defined function in Java?
package others;

import java.util.Random;
import java.util.Scanner;

public class RandomStringGenerator {

    // User-defined function to generate a random string of specified length
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
    }

    // User-defined function to check if a string is numeric
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length for the random string: ");
        String input = scanner.nextLine();

        if (!isNumeric(input)) {
            System.out.println("Invalid input. Please enter a positive integer.");
        } else {
            int length = Integer.parseInt(input);
            if (length <= 0) {
                System.out.println("Length must be greater than 0.");
            } else {
                String randomStr = generateRandomString(length);
                System.out.println("Generated Random String: " + randomStr);
            }
        }

        scanner.close();
    }
}
