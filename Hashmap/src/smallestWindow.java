import java.util.HashMap;

/*Given two strings S and P. Find the smallest window in the string S consisting 
of all the characters(including duplicates) of the string P.  Return "-1"
in case there is no such window present. In case there are multiple such windows
of same length, return the one with the least starting index. 

Example 1:

Input:
S = "timetopractice"
P = "toc"
Output: 
toprac
Explanation: "toprac" is the smallest
substring in which "toc" can be found.*/
public class smallestWindow {

	public static void main(String[] args) {
		/*
		 * Method 1 ( Brute force solution ) 1- Generate all substrings of string1
		 * (“this is a test string”) 2- For each substring, check whether the substring
		 * contains all characters of string2 (“tist”) 3- Finally, print the smallest
		 * substring containing all characters of string2.
		 */
		System.out.println(smallestWindow("timetopractice","toc"));
	}

	/*
	 * Method 2 ( Efficient Solution )
	 * 
	 * First check if the length of the string is less than the length of the given
	 * pattern, if yes then “no such window can exist “.
	 *  Store the occurrence of
	 * characters of the given pattern in a hash_pat[]. 
	 * we will be using two pointer
	 * technique basically.
	 *  Start matching the characters of pattern with the
	 * characters of string i.e. increment count if a character matches.
	 *  Check if
	 * (count == length of pattern ) this means a window is found.
	 *  If such a window
	 * found, try to minimize it by removing extra characters from the beginning of
	 * the current window. delete one character from first and again find this
	 * deleted key at right, once found apply step 5 . 
	 * Update min_length. Print the
	 * minimum length window.
	 */
	static final int no_of_chars = 256;
	public static String smallestWindow(String str, String pat) {
		 	int len1 = str.length();
	        int len2 = pat.length();
	 
	        // Check if string's length is less than pattern's length. If yes then no such
	        // window can exist
	        if (len1 < len2) {
	            System.out.println("No such window exists");
	            return "";
	        }
	 
	        int hash_pat[] = new int[no_of_chars];
	        int hash_str[] = new int[no_of_chars];
	 
	        // Store occurrence ofs characters of pattern
	        for (int i = 0; i < len2; i++)
	            hash_pat[pat.charAt(i)]++;
	 
	        int start = 0, start_index = -1,
	            min_len = Integer.MAX_VALUE;
	 
	        // Start traversing the string Count of characters
	        int count = 0;
	        for (int j = 0; j < len1; j++) {
	           
	            // Count occurrence of characters of string
	            hash_str[str.charAt(j)]++;
	 
	            // If string's char matches with pattern's char then increment count
	            if (hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
	                count++;
	 
	            // If all the characters are matched
	            if (count == len2) {
	               
	                // Try to minimize the window
	                while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]
	                       || hash_pat[str.charAt(start)] == 0) {
	 
	                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
	                        hash_str[str.charAt(start)]--;
	                    start++;
	                }
	 
	                // update window size
	                int len_window = j - start + 1;
	                if (min_len > len_window) {
	                    min_len = len_window;
	                    start_index = start;
	                }
	            }
	        }
	 
	        // If no window found
	        if (start_index == -1) {
	            System.out.println("No such window exists");
	            return "";
	        }
	 
	        // Return substring starting from start_index and length min_len
	        return str.substring(start_index, start_index + min_len);
	}
}