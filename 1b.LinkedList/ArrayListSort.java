//Write a java program for getting different colors through ArrayList interface and  sort them 
//using Collections.sort( ArrayListObj)

package others;

import java.util.*;
public class ArrayListSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ls = new ArrayList<>();
		ls.add("Orange");
		ls.add("geen");
		ls.add("pink");
		ls.add("red");
		ls.add("Blue");
		System.out.println("Before sorting:");
		System.out.println(ls);
		Collections.sort(ls);
		System.out.println("After sorting:");
		System.out.println(ls);
	}

}
