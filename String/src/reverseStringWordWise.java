import java.util.Scanner;

public class reverseStringWordWise {

	private static void revrseString(String str) {

		String output = "";
		int i = str.length() - 1;
		int j = str.length() - 1;
		//Iterate in reverse direction
		while (i > 0) {
			//once space is found add substring to output string
			if (str.charAt(i) == ' ') {
				output = output + str.substring(i + 1, j + 1) + " ";
				i = i - 1;
				j = i;
			} else {
				i--;
			}
		}
		//adding last word into the output string
		output = output + str.substring(i, j + 1);
		System.out.print(output);
	}

	public static void main(String[] args) {

		/*
		 * Scanner sc = new Scanner(System.in); String str = sc.nextLine();
		 */
		String str = "Maa ki chuu";
		revrseString(str);
	}
}
