import java.util.Arrays;

public class NumberOfVowels {
//	Given a sentence, find the words with a specified number of vowels.
//	No. of vowels : 2
//
//	String str = "I am learning Streams API in java";
//	O/p: Streams API Java
	public static void main(String[] args) {
		String str = "I am learning Streams API in java";
		int noOfVowels = 2;
		//Here used regex to relpace all char which are not vowel to empty string
		Arrays.stream(str.split(" ")).
			filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == noOfVowels)
			.forEach(System.out :: println);
	}
}
