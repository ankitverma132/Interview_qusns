
//Sort an array of strings according to string lengths
//We are given an array of strings, we need to sort the
//array in increasing order of string lengths.
//
//Examples:
//
//Input : {"GeeksforGeeeks", "I", "from", "am"}
//Output : I am from GeeksforGeeks
//
//Input :  {"You", "are", "beautiful", "looking"}
//Output : You are looking beautiful
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class lengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {

		if (s1.length() > s2.length()) {
			return 1;
		} else if (s1.length() == s2.length()) {
			return 0;
		} else {
			return -1;
		}
	}

}

public class sortStringByLength {

	// Using Insertion Sort
	/*
	 * public static void sortByLength(String[] str) {
	 * 
	 * for (int i = 1; i < str.length; i++) { String temp = str[i];
	 * 
	 * // Insert s[j] at its correct position int j = i - 1; while (j >= 0 &&
	 * temp.length() < str[j].length()) { str[j + 1] = str[j]; j--; } str[j + 1] =
	 * temp; } for( int i = 0; i < str.length; i++ ) { System.out.print( str[i] +
	 * " "); } }
	 */

	// Using Comparator
	public static void sortByLength(String[] str) {

		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < str.length; i++) {
			al.add(str[i]);
		}

		Collections.sort(al, new lengthComparator());
		for (int i = 0; i < str.length; i++) {
			System.out.println(al.get(i));
		}
	}

	public static void main(String[] args) {

		String[] arr = { "geeks", "i", "from", "am" };
		sortByLength(arr);
	}
}