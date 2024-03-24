//Given an input string (STR), print all possible permutations of the input string.
/*Sample Input 1:
cba
Sample Output 1:
abc
acb
bac
bca
cab
cba*/

public class PrintPermutations {
	//Using backtracking
	public static void main(String[] args) {

		String input = "cba";
		helper(input, "");
	}

	private static void helper(String s, String answer) {
		if (s.length() == 0) {
			System.out.println(answer);
			return;
		}
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String left_substr = s.substring(0, i);
			String right_substr = s.substring(i + 1);
			String rest = left_substr + right_substr;
			helper(rest, answer + ch);
		}
	}
}