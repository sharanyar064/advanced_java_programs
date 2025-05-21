package others;
import java.util.LinkedList;

public class linkedlistofferlast {
    public static void main(String[] args) {
        LinkedList<String> l_listobj = new LinkedList<>();
        l_listobj.add("Red");
        l_listobj.add("Green");
        l_listobj.add("Blue");
        System.out.println("Original LinkedList: " + l_listobj);
        l_listobj.offerLast("Pink");
        System.out.println("Updated LinkedList after adding 'Pink' at the end: " + l_listobj);
    }
}
