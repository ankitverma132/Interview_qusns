/*Given an array arr[] of size N-1 with integers in the range of [1, N], the task is to find the missing number from the first N integers.

Note: There are no duplicates in the list.

Examples: 

Input: arr[] = {1, 2, 4, 6, 3, 7, 8}, N = 8
Output: 5
Explanation: The missing number between 1 to 8 is 5*/
/*Follow the steps mentioned below to implement the idea:

Calculate the sum of the first N natural numbers as sumtotal= N*(N+1)/2.
Traverse the array from start to end.
Find the sum of all the array elements.
Print the missing number as SumTotal – sum of array*/
public class MissingNo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5 };
		int N = arr.length;
		System.out.println(getMissingNo(arr, N));

	}
	// Function to find the missing number
	public static int getMissingNo(int[] nums, int n)
	{
		int sum = ((n + 1) * (n + 2)) / 2;
		for (int i = 0; i < n; i++)
			sum -= nums[i];
		return sum;
	}
}
