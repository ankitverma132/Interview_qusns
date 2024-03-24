/*Longest Increasing Subsequence
Send Feedback
Given an array with N elements, you need to find the length of the longest subsequence 
in the given array such that all elements of the subsequence are sorted in strictly increasing order.
Input Format
The first line of input contains an integer N. The following line contains N space separated
integers, that denote the value of elements of array.
Output Format
The first and only line of output contains the length of longest subsequence.
Constraints
1 <= N <= 10^3
Time Limit: 1 second
Sample Input 1 :
6
5 4 11 1 16 8
Sample Output 1 :
3
Sample Output Explanation
Length of longest subsequence is 3 i.e. (5,11,16) or (4,11,16).
Sample Input 2 :
3
1 2 2
Sample Output 2 :
2*/
public class longestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {5, 4, 11, 18, 16, 8};
		System.out.print(getSequencelength(arr));
	}
	public static int getSequencelength(int arr[]) {

		int[] storage = new int[arr.length];
		storage[0] = 1;
		if( arr[1] > arr[0] ) {
			storage[1] = 2;
		}else {
			storage[1] = 1;
		}

		for( int i = 2; i < arr.length; i++ ) {
			int length = 1;
			for( int j = 0; j < i; j++) {
				if( arr[j] < arr[i] && storage[j] >= length ) {
					length = storage[j] + 1;
				}               
			}
			storage[i] = length;
		}
		for( int i = 0; i < storage.length; i++ ) {
			System.out.println(storage[i]);
		}
		int maxL = Integer.MIN_VALUE;
		for( int i = 0; i < storage.length; i++ ) {
			if( storage[i]  > maxL ) {
				maxL = storage[i];
			}
		}
		return maxL;
	}
}
