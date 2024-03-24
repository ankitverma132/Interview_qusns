//1189. Maximum Number of Balloons
//Given a string text, you want to use the characters 
//of text to form as many instances of the word "balloon" as possible.
//You can use each character in text at most once.
//Return the maximum number of instances that can be formed.
//Example 1:
//Input: text = "nlaebolko"
//Output: 1
//Example 2:
//Input: text = "loonbalxballpoon"
//Output: 2
//Example 3:
//Input: text = "leetcode"
//Output: 0
public class maxNumOfBalloons {

	public static int maxNumberOfBalloons(String text) {

		if (text == null || text.length() < 7)
			return 0;

		int[] c = new int[26];
		//Storing frequency of each character of string in a char array
		for (char ch : text.toCharArray())
			c[ch - 'a']++;

		int res = Integer.MAX_VALUE;
		res = Math.min(res, c['b' - 'a']);
		res = Math.min(res, c['a' - 'a']);
		res = Math.min(res, c['l' - 'a'] / 2);
		res = Math.min(res, c['o' - 'a'] / 2);
		res = Math.min(res, c['n' - 'a']);
		return res;
	}
	
	public static void main(String[] args) {
		System.out.print(maxNumberOfBalloons("loonbalxballpoon"));
	}
}