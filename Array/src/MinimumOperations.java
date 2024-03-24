/*Minimum number of changes such that elements are first Negative and then Positive

Given an array arr[] of size N. The task is to find the minimum number 
of changes required to convert the array such that for any index 0 ≤ k < N, 
the elements in the array upto k-th index will be less than zero and after k-th index will be greater than zero.
That is: 
arr[0] < 0, arr[1] < 0, …, arr[k] < 0 and arr[k + 1] > 0, arr[k + 2] > 0, …, arr[N – 1] > 0. 
Examples: 
Input: arr[] = { -1, 1, 2, -1} 
Output: 1 
Replace last -1 with any positive integer.
Input: arr[] = { -1, 0, 1, 2 } 
Output: 1 
Replace 0 with any negative integer.
Approach: First, find for each valid k, the number of non-negative integers to the left of
it and the number of non-positive integers to the right. Now, run a loop for each valid k
(0 ≤ k <n) and find the sum of the number of non-negative integers left to it and number 
of non-positive integers right to it, and the minimum of these values for every k is our required answer.*/

public class MinimumOperations {

	public static void main(String[] args) {
		int[] a = { -1, 1, 2, -1 } ;
		int n = a.length;
		System.out.print(Minimum_Operations(a, n));

	}
	// Function to return the count of minimum operations required
	static int Minimum_Operations(int[] a, int n) {
		// To store the count of negative integers on the right of the current index (inclusive)
		int[] np = new int[n + 1];
		np[n] = 0;

		// Find the count of negative integers on the right
		for (int i = n - 1; i >= 0; i--) {
			np[i] = np[i + 1];
			//If current element is negative
			if (a[i] <= 0)
				np[i]++;
		}
		//To store the count of positive elements
		int pos = 0;
		int ans = n;
		// Find the positive integers on the left
		for (int i = 0; i < n - 1; i++) {
			// If current element is positive
			if (a[i] >= 0)
				pos++;
			// Update the answer
			ans = Math.min(ans, pos + np[i + 1]);
		}
		// Return the required answer
		return ans;
	}
}