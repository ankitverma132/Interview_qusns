/*Given two strings s and t of lengths m and n respectively, find the edit distance between the strings.
Edit Distance
Edit Distance of two strings is minimum number of operations required to make one string equal to other.
 In order to do so you can perform any of the following three operations only :
1. Delete a character
2. Replace a character with another one
3. Insert a character*/
/*Sample Input 1 :
abc
dc
Sample Output 1 :
2*/
public class editDistance {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "dc";
		System.out.print(editDistance(s1, s2));

	}
	public static int editDistance(String s1, String s2){		
		// If first string is empty, the only option is to
        // insert all characters of second string into first
		if( s1.length() == 0 ) {
			return s2.length();
		}
		// If second string is empty, the only option is to
        // remove all characters of first string
		if( s2.length() == 0 ) {
			return s1.length();
		}
		if( s1.charAt(0) == s2.charAt(0) ) {
			return editDistance( s1.substring(1), s2.substring(1));
		}
		else {
			// If last characters are not same, consider all
	        // three operations on first character of first
	        // string, recursively compute minimum cost for all
	        // three operations and take minimum of three
	        // values.
			//if insertion
			int op1 = editDistance( s1, s2.substring(1) );
			//if deletion
			int op2 = editDistance( s1.substring(1), s2 );
			//if substitute
			int op3 = editDistance( s1.substring(1), s2.substring(1));

			return 1 + Math.min(op1, Math.min(op2, op3));
		}
	}
}
