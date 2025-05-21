// Q7. Write a Java Program for Shortening a string to a specified length and adds an ellipsis using user defined function truncate().
package others;

import java.util.Scanner;

public class StringTruncator {

    // User-defined function to truncate the string and add ellipsis
    public static String truncate(String str, int maxLength) {
        if (str == null || maxLength < 0) {
            return "";
        }
        if (str.length() <= maxLength) {
            return str;
        }
        if (maxLength <= 3) {
            return "...".substring(0, maxLength);
        }
        return str.substring(0, maxLength - 3) + "...";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Prompt user to enter the maximum length
        System.out.print("Enter the maximum length: ");
        int length = scanner.nextInt();

        // Call the truncate function
        String truncated = truncate(input, length);

        // Output the result
        System.out.println("Truncated string: " + truncated);

        scanner.close();
    }
}
