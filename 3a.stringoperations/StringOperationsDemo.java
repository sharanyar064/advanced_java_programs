// Develop a java program for performing various string operations with different string 
//handling functions directed  as follows:
// String Creation and Basic Operations, Length and Character Access, String Comparison,  String 
//Searching, Substring Operations ,  String Modification, Whitespace Handling, String Concatenation, 
//String Splitting,  StringBuilder Demo, String Formatting , Validate Email with contains( )  and 
//startsWith() and endsWith() 


package others;
import java.util.Arrays;

public class StringOperationsDemo {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "  Welcome to Java Programming!  ";
        String email = "user@example.com";

        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("String 3: " + str3);

        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 1 in str1: " + str1.charAt(1));

        System.out.println("str1 equals str2: " + str1.equals(str2));
        System.out.println("str1 equalsIgnoreCase 'hello': " + str1.equalsIgnoreCase("hello"));
        System.out.println("str1 compareTo str2: " + str1.compareTo(str2));

        System.out.println("str3 contains 'Java': " + str3.contains("Java"));
        System.out.println("Index of 'Java' in str3: " + str3.indexOf("Java"));
        System.out.println("Last index of 'o' in str3: " + str3.lastIndexOf("o"));

        System.out.println("Substring of str3 (start at 2): " + str3.substring(2));
        System.out.println("Substring of str3 (2, 10): " + str3.substring(2, 10));

        System.out.println("str3 toUpperCase: " + str3.toUpperCase());
        System.out.println("str3 toLowerCase: " + str3.toLowerCase());
        System.out.println("str3 trimmed: " + str3.trim());
        System.out.println("str3 replace 'Java' with 'Python': " + str3.replace("Java", "Python"));

        System.out.println("Concatenated String: " + str1.concat(" ").concat(str2));
        
        String[] words = str3.trim().split(" ");
        System.out.println("Words in str3: " + Arrays.toString(words));

        StringBuilder sb = new StringBuilder();
        sb.append("This ");
        sb.append("is ");
        sb.append("StringBuilder ");
        sb.append("demo.");
        System.out.println("StringBuilder result: " + sb.toString());

        String name = "John";
        int age = 25;
        String formatted = String.format("Name: %s, Age: %d", name, age);
        System.out.println("Formatted string: " + formatted);

        System.out.println("Email contains '@': " + email.contains("@"));
        System.out.println("Email starts with 'user': " + email.startsWith("user"));
        System.out.println("Email ends with '.com': " + email.endsWith(".com"));
    }
}
