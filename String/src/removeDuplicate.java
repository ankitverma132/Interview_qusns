public class removeDuplicate {

	private static String removeDuplicate(String str) {

		if (str.length() == 1) {
			return str;
		}
		String smallAns = removeDuplicate(str.substring(1));
		if (smallAns.charAt(0) == str.charAt(0)) {
			return smallAns;
		}
		return str.charAt(0) + smallAns;
	}

	public static void main(String[] args) {

		String str = "aabbccddd";
		System.out.println(removeDuplicate(str));

	}
}
