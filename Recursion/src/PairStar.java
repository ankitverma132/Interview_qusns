/*Given a string S, compute recursively a new string where identical chars
that are adjacent in the original string are separated from each other by a "*".*/

public class PairStar {

	public static void main(String[] args) {
		String str = "aaba";
		System.out.println(addStars(str));
	} 

	public static String addStars(String s) {

		return helper(s, 0, 1);
	}
	public static String helper(String s, int i, int j) {

		if( i == s.length() - 1) {
			return Character.toString(s.charAt(i));
		}
		String smallAns = helper(s, i+1, j+1);

		if( s.charAt(i) == s.charAt(j)){
			return Character.toString(s.charAt(i)) + "*" + smallAns;			
		}
		else {
			return Character.toString(s.charAt(i)) + smallAns;
		}
	}
}