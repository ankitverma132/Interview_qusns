import java.util.Scanner;

/*Find the String
Problem Statement
You are given a matrix of characters. The matrix has N rows and M columns. Given a string s,
you have to tell if it is possible to generate that string from given matrix.
Rules for generating string from matrix are:

You have to pick first character of string from row 1, second character from row 2 and so on.
The (N+1)th character of string is to be picked from row 1, that is, you can traverse the rows 
in a cyclic manner (row 1 comes after row N).
If an occurrence of a character is picked from a row, you cannot pick the same occurrence again from that row.
You have to print Yes if given string can be generated from matrix using the given rules, else print No.
Input
First line consists of two integers N and M, denoting the matrix dimensions.
Next N lines consist of M characters each.
Last line consists of a string s.

Output
Print "Yes" if string can be generated else print "No". Answer for each test case should come in a new line.

Example
Sample Input 1:
3 3
aba
xyz
bdr
axbaydb

Sample Output 1:
Yes

Explanation
We pick "a" from row 1. Now, we can only pick one more "a" from row 1 as one "a" is already used.
Similarly, "x" from row 2, "b" from row 3.
Now, we again go back to row 1.
We pick "a" from row 1, "y" from row 2 and so on.*/

public class findString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int i = 0; i < T; i++) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			String[][] arr = new String[n][1];

			for (int j = 0; j < n; j++) {
				arr[j][0] = sc.next();
			}
			String s1 = sc.next();
			int l = 0;
			boolean ans = true;

			while (s1.length() != l) {
				if (arr[l%n][0].contains(String.valueOf(s1.charAt(l)))) {
					ans = true;
					arr[l%n][0] = arr[l%n][0].replaceFirst(String.valueOf(s1.charAt(l)),"");
				} else {
					ans = false;
					break;
				}
				l+=1;
			}
			if (ans == true) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}