package java8codeclasses;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayComparators {

	public static void main(String[] args) {
		String[] names = {"Name1","Game1","Tree1","Tree2","canal1"};
		
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		};
		
		Arrays.sort(names, comparator);
		
		System.out.println(Arrays.toString(names));

	}

}
