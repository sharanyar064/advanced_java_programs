
//Q: How can we verify if a string contains only numeric characters using a user-defined function in Java?
package others;

import java.util.Scanner;

public class NumericCheck {

 // User-defined function to check if the string is numeric
 public static boolean isNumeric(String str) {
     if (str == null || str.isEmpty()) {
         return false;
     }
     // Check each character
     for (char c : str.toCharArray()) {
         if (!Character.isDigit(c)) {
             return false;
         }
     }
     return true;
 }

 // Main method to test the function
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     System.out.print("Enter a string to check if it is numeric: ");
     String input = scanner.nextLine();

     if (isNumeric(input)) {
         System.out.println("The string contains only numeric characters.");
     } else {
         System.out.println("The string does NOT contain only numeric characters.");
     }

     scanner.close();
 }
}
