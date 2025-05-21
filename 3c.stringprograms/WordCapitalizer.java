////Write a Java Program for  Capitalizing the first letter of each word. using user defined function 
////capitalizeWords()

package others;
import java.util.Scanner;

public class WordCapitalizer {

    // User-defined function to capitalize the first letter of each word
    public static String capitalizeWords(String str) {
        // Split the string into words based on whitespace
        String[] words = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        // Loop through each word
        for (String word : words) {
            if (!word.isEmpty()) {
                // Convert first character to uppercase and the rest to lowercase
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1).toLowerCase())
                      .append(" ");
            }
        }

        // Return the final string after trimming extra space
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a sentence
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Call the user-defined function
        String capitalized = capitalizeWords(input);

        // Output the result
        System.out.println("Capitalized sentence: " + capitalized);

        scanner.close();
    }
}
