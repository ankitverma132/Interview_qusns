/*Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
10 
95 -97 -387 -435 -5 -70 897 127 23 284
Output:
5*/
import java.util.HashMap;

public class maxSubArrayWithZeroSum {
	public static int lengthOfLongestSubsetWithZeroSum(int[] arr) {

		int sum = 0;
		int maxLength = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		//Hashmap will contain sum till that index as key and index as value
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum == 0) {
				// If sum is zero means till this element sum is zero
				// i.e. maxlength of subarray with zero sum is i+1
				maxLength = i + 1;
				map.put(sum, i);
			} else {
				//If sum is not zero so check either sum is repeated or not
				
				// Sum get repeated means "in-between element sum" was zero then only it get repeated
				// for ex here on 2nd index sum get repeated to 15 because 2 and -2 sum out to be 0.
				if (map.containsKey(sum)) {
					// map.get(sum) will give index where last time that sum was found so after that
					// element till current element sum was 0.
					if (maxLength < i - map.get(sum)) {
						maxLength = i - map.get(sum);
					}
				} else {
					//if sum is not repeated put sum and index as key value pair
					map.put(sum, i);
				}
			}
		}
		return maxLength;

	}

	public static void main(String[] args) {
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		System.out.println(lengthOfLongestSubsetWithZeroSum(arr));
	}
}