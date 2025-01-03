/*How to Left or Right rotate an Array in Java
Given an array arr[] of size N and D index,
the task is to rotate the array by the D index.

Example:
Input: 
arr[] = {1, 2, 3, 4, 5} 
D = 2 
Output: 
3 4 5 1 2 */

public class ArrayRotation {
	// =====================================================
	public static void leftRotate(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			// Calling function to rotate array n times
			// which will rotate array by 1 time each time
			leftRotateByOne(arr);
		}
	}

	public static void leftRotateByOne(int[] arr) {
		// storing first value of array in a temp variable
		int temp = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length - 1] = temp;
	}

	// ======================================================
	public static void leftRotateSecondMethod(int[] arr, int n) {

		if (arr.length == 0) {
			return;
		}
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, arr.length - 1 - n);
		reverse(arr, arr.length - n, arr.length - 1);
	}

	private static void reverse(int[] arr, int start, int end) {

		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	// ======================================================
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		// leftRotate(arr, 2);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		leftRotateSecondMethod(arr, 2);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

	}
}