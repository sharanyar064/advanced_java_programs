package others;
import java.util.ArrayList;
import java.util.Scanner;

public class ColorList {
    public static void main(String[] args) {
        // Step 1: Create an ArrayList of colors
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Black");

        // Step 2: Display original list
        System.out.println("Original color list:");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println((i + 1) + ". " + colors.get(i));
        }

        // Step 3: Ask user for the index (nth position) to remove
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the position (1 to " + colors.size() + ") to delete: ");
        int n = scanner.nextInt();

        // Step 4: Delete the nth element (index n - 1)
        if (n >= 1 && n <= colors.size()) {
            String removedColor = colors.remove(n - 1);
            System.out.println("\nRemoved: " + removedColor);
        } else {
            System.out.println("Invalid position!");
        }

        // Step 5: Display updated list
        System.out.println("\nUpdated color list:");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println((i + 1) + ". " + colors.get(i));
        }

        scanner.close();
    }
}
