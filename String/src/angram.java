import java.util.Arrays;

/*Given two strings. The task is to check whether given strings are anagrams of each other or not. 

An anagram of a string is another string that contains the same characters, 
only the order of characters can be different. For example, “abcd” and “dabc” are an anagram of each other.

Examples:

Input: str1 = “listen”  str2 = “silent”
Output: “Anagram”
Explanation: All characters of “listen” and “silent” are the same.*/

public class angram {

	public static void main(String[] args) {
		char str1[] = ("listen").toCharArray();
		char str2[] = ("silent").toCharArray();

		// Function call
		if (areAnagram(str1, str2))
			System.out.println("The two strings are"
					+ " anagram of each other");
		else
			System.out.println("The two strings are not"
					+ " anagram of each other");

	}
	static int NO_OF_CHARS = 256;

	/* function to check whether two strings
	    are anagram of each other */
	static boolean areAnagram(char str1[], char str2[])
	{

		// If both strings are of different length.
		// Removing this condition will make the program
		// fail for strings like "aaca" and "aca"
		if (str1.length != str2.length)
			return false;

		// Create 2 count arrays and initialize
		// all values as 0
		int count1[] = new int[NO_OF_CHARS];
		Arrays.fill(count1, 0);
		int count2[] = new int[NO_OF_CHARS];
		Arrays.fill(count2, 0);
		int i;

		// For each character in input strings,
		// increment count in the corresponding
		// count array
		for (i = 0; i < str1.length && i < str2.length;
				i++) {
			count1[str1[i]]++;
			count2[str2[i]]++;
		}
		// Compare count arrays
		for (i = 0; i < NO_OF_CHARS; i++)
			if (count1[i] != count2[i])
				return false;

		return true;
	}
}
