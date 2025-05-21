//Write a Java Program for Eliminating all whitespace characters from a string using user defined 
//function removeWhitespace()
//

package others;
import java.util.Scanner;

public class WhitespaceRemover {

    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result = removeWhitespace(input);
        System.out.println("String without whitespace: " + result);

        scanner.close();
    }
}
