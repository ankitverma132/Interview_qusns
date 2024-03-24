public class replaceCharacter {

	public static String replaceCharacter(String input, char c1, char c2) {
		// return helper( input, c1, c2, 0);
		if (input.length() == 0) {
			return input;
		}
		String ans = "";
		if (input.charAt(0) == c1) {
			ans = ans + c2;
		} else {
			ans = ans + input.charAt(0);
		}
		String smallAns = replaceCharacter(input.substring(1), c1, c2);
		return ans + smallAns;
	}

	public static void main(String[] args) {

		String str = "abacd";
		System.out.println(replaceCharacter(str,'a','x'));
	}
}