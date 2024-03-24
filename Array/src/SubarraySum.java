/*Given an array arr[] of non-negative integers and an integer sum, find a subarray that adds to a given sum.

Note: There may be more than one subarray with sum as the given sum, print first such subarray. 

Examples: 

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Output: Sum found between indexes 2 and 4
Explanation: Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Output: Sum found between indexes 1 and 4
Explanation: Sum of elements between indices 1 and 4 is 4 + 0 + 0 + 3 = 7

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
Explanation: There is no subarray with 0 sum*/
/*The idea is simple as we know that all the elements in subarray are positive so,
If a subarray has sum greater than the given sum then there is no possibility that
adding elements to the current subarray will be equal to the given sum. So the Idea 
is to use a similar approach to a sliding window. 

Start with an empty subarray 
add elements to the subarray until the sum is less than x( given sum ). 
If the sum is greater than x, remove elements from the start of the current subarray.
Follow the steps given below to implement the approach:

Create two variables, start=0, currentSum = arr[0]
Traverse the array from index 1 to end.
Update the variable currentSum by adding current element, currentSum = currentSum + arr[i]
If the currentSum is greater than the given sum, update the variable currentSum as currentSum = currentSum – arr[start],
and update start as, start++.
If the currentSum is equal to given sum, print the subarray and break the loop.*/
public class SubarraySum {
	
	int subArraySum(int arr[], int n, int sum) {
        int currentSum = arr[0], start = 0, i;
        //Pick a starting point
        for (i = 1; i <= n; i++) {
            // If currentSum exceeds the sum, then remove the starting elements.
            while (currentSum > sum && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }
            // If currentSum becomes equal to sum, then return true
            if (currentSum == sum) {
                int p = i - 1;
                System.out.println("Sum found between indexes " + start + " and " + p);
                return 1;
            }
            // Add this element to curr_sum
            if (i < n)
                currentSum = currentSum + arr[i];
        }
 
        System.out.println("No subarray found");
        return 0;
    }
	public static void main(String[] args) {
		SubarraySum arraysum = new SubarraySum();
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int n = arr.length;
		int sum = 23;
		arraysum.subArraySum(arr, n, sum);
	}
}