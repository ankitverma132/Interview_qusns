import java.util.HashMap;

public class maxFrequencyNumber {

	// Using hashmap
	public static int maxFreqNum(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();
		
		// First put frequency of all array element in a hashmap
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		int num = -1;
		int count = Integer.MIN_VALUE;
		// Check the key with maximum value
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) > count) {
				count = map.get(arr[i]);
				num = arr[i];
			}
		}
		return num;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2, 3, 4 };
		System.out.println(maxFreqNum(arr));
	}
}
