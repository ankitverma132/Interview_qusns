
import java.util.HashMap;

public class distinctElementInEveryWindowK {

	private static void countWindowDistinct(int[] arr, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int distC = 0;
		for (int i = 0; i < k; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);

			} else {
				map.put(arr[i], 1);
				distC++;
			}
		}
		
		System.out.println(distC);
		
		for (int i = k; i < arr.length; i++) {
			// Remove first element of previous window
			// If there was only one occurrence, then
			// reduce distinct count.
			if (map.get(arr[i - k]) == 1) {
				map.remove(arr[i - k]);
				distC--;
			} else {
				map.put(arr[i - k], map.get(arr[i - k]) - 1);
			}
			// Add new element of current window
			// If this element appears first time,
			// increment distinct element count
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
				distC++;
			}
			System.out.println(distC);
		}

	}
	public static void main(String[] args) {

		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		countWindowDistinct(arr, k);
	}
}