
public class secondLargestInArray {

	public static int secondLargest(int[] arr) {

		int secondMax = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		/*
		 * iterate over elements, if larger element found update max and update
		 * secondMax with max. if not larger then check if it is larger then second
		 * element then update second larger element
		 */
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];

			} else if (arr[i] > secondMax && arr[i] != max) {
				secondMax = arr[i];
			}
		}
		return secondMax;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 3, 2, 4, 5, 6 };
		System.out.println(secondLargest(arr));
	}

}
