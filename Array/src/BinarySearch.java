
public class BinarySearch {

	// Iteratively
	private static int binarySearch(int[] arr, int num) {

		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {

			int mid = (start + end) / 2;

			if (num > arr[mid]) {
				start = mid + 1;
			} else if (num > arr[mid]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

//=====================================================================
	// Recursively
	private static int binarySearchRecursively(int[] arr, int num) {

		return binarySearchRecursively(arr, num, 0, arr.length - 1);
	}

	private static int binarySearchRecursively(int[] arr, int num, int start, int end) {

		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (arr[mid] == num) {
			return mid;
		} else if (num > arr[mid]) {
			return binarySearchRecursively(arr, num, mid + 1, end);
		} else {
			return binarySearchRecursively(arr, num, start, mid - 1);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		int num = 5;
		System.out.println(binarySearchRecursively(arr, num));
	}

}