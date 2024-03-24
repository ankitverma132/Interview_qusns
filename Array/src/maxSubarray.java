
public class maxSubarray {

	/*
	 * Brute force method Time: O(N^3) Space: O(1) For each element, we construct
	 * all possible subarrays starting from this element. Totally there are at most
	 * N^2 subarrays. Also, calculating the sum of each subarray takes O(N).
	 */
	public static int maxSubArray(int[] nums) {

		/*
		 * int n = nums.length; int maxSum = Integer.MIN_VALUE;
		 * 
		 * for (int i = 0; i < n; ++i) { for (int j = i; j < n; ++j) { int sum = 0; for
		 * (int k = i; k <= j; ++k) { sum += nums[k]; } maxSum = Math.max(maxSum, sum);
		 * } } return maxSum;
		 */
//		Why did you calculate the sum separately?
//		Note: In the inner loop, start from i+1. Don't
//		initialize sum as 0 and start from i.
//		Time: O(N^2)
//		Space: O(1)
		/*
		 * int n = nums.length; int maxSum = Integer.MIN_VALUE; for (int i = 0; i < n;
		 * ++i) { // starts at i
		 * 
		 * int sum = nums[i]; maxSum = Math.max(maxSum, sum); // starts from the next
		 * element for (int j = i + 1; j < n; ++j) { sum += nums[j]; maxSum =
		 * Math.max(maxSum, sum); } } return maxSum;
		 */

		// Kadane Algorithm

		int max = nums[0];
		int maxEndingHere = nums[0];

		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			max = Math.max(max, maxEndingHere);
		}
		return max;

	}

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(maxSubArray(a));
	}
}