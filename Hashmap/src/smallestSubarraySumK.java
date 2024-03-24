
/*Given an array arr[] consisting of N integers, the task is to find the length of the Smallest subarray with a sum equal to K.

Examples:

Input: arr[] = {2, 4, 6, 10, 2, 1}, K = 12 
Output: 2 
Explanation: All possible subarrays with sum 12 are {2, 4, 6} and {10, 2}.

Input: arr[] = {-8, -8, -3, 8}, K = 5 
Output: 2*/
/*Check if, currPrefixSum is equal to K.
If yes, then use this length of subarray (currPrefixSum) to minimize the result.
Also, check if the required prefix sum (currPrefixSum – K) has been calculated previously or not.
If the required prefix sum is calculated previously then find its last occurrence of that prefix 
sum and use it to calculate the length of the current prefix sum equal to K by (current index
		– last occurrence of required prefix sum) and use it to minimize the result.
Store the currPrefixSum which is ending at ith index into the map.
Finally, return the result.*/ 
import java.util.HashMap;

public class smallestSubarraySumK {

	public static void main(String[] args) {
		int arr[] = {-8, -8, -3, 8};
	    int n = arr.length;
	    int K = 5;
	    System.out.println(smallestSubarraySumK(arr, n, K));
	}
	// Function to find the Smallest Subarray with Sum K from an Array
	static int smallestSubarraySumK(int arr[], int n, int K) {
	    // Use map here to store the prefixSum ending at ith index.
	    HashMap<Integer, Integer> mp = new HashMap<>();
	 
	    // Store the current Prefix sum till ith index;
	    int currPrefixSum = 0;
	 
	    // Store the minimum size subarray whose sum is K
	    int result = Integer.MAX_VALUE;
	 
	    for(int i = 0; i < n; i++) {
	        currPrefixSum += arr[i];
	 
	        // Check if the current prefix sum is equals to K
	        if(currPrefixSum == K) {
	            int currLen = i + 1;
	            result = Math.min(result, currLen);
	        }
	 
	        // Required PrefixSum
	        int requirePrefixSum = currPrefixSum - K;
	        // Check if there exist any required Prefix Sum or not
	        if(mp.containsKey(requirePrefixSum)){
	            result = Math.min(result, i - mp.get(requirePrefixSum));
	        }
	        // Store the current prefix sum ending at i
	        mp.put(currPrefixSum, i);
	    }
	    if(result >= Integer.MAX_VALUE) return -1;
	    // return the result
	    return result;
	}
}