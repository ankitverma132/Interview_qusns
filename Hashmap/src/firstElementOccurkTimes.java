
/*Given an array of n integers. The task is to find the first element that occurs k number of times.
If no element occurs k times the print -1. 
 */
import java.util.HashMap;

public class firstElementOccurkTimes {

	public static void main(String[] args) {
		int arr[] = {1, 7, 4, 3, 4, 8, 7};
		int n = arr.length;
		int k = 2;
		System.out.println(firstElement(arr, n, k));
	}

	// function to find the first element occurring k number of times
	static int firstElement(int arr[], int n, int k) {
		// unordered_map to count occurrences of each element
		HashMap<Integer, Integer> count_map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int a = 0;
			if(count_map.get(arr[i])!=null) {
				a = count_map.get(arr[i]);
			}
			count_map.put(arr[i], a+1);
		}
		for (int i = 0; i < n; i++) {
			if (count_map.get(arr[i]) == k) {
				return arr[i];
			}
		}
		// no element occurs k times
		return -1;
	}
}