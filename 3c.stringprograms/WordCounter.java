// Q: How can we count the number of words in a string using a user-defined function in Java?
package others;

import java.util.Scanner;

public class WordCounter {

    // User-defined function to count words in a string
    public static int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        // Split the string by whitespace (one or more spaces, tabs, etc.)
        String[] words = input.trim().split("\\s+");
        return words.length;
    }

    // Main method to test the function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        int wordCount = countWords(text);
        System.out.println("Number of words: " + wordCount);

        scanner.close();
    }
}
