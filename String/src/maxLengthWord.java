public class maxLengthWord {

	private static String maxLengthWord(String str) {

		int i = 0, j = 0;
		int maxLength = Integer.MIN_VALUE;
		String maxLengthWord = "";

		while (j <= str.length()) {

			if (j == str.length() && (j - i) > maxLength) {
				maxLengthWord = str.substring(i, j);
				j++;
			} else if (str.charAt(j) == ' ') {
				if ((j - i) > maxLength) {
					maxLength = j - i;
					maxLengthWord = str.substring(i, j);
				}
				j++;
				i = j;
			} else {
				j++;
			}
		}
		return maxLengthWord;
	}

	public static void main(String[] args) {

		String str = "This is test string";
		System.out.println(maxLengthWord(str));
	}
}