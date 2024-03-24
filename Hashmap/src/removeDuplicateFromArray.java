import java.util.ArrayList;
import java.util.HashMap;

public class removeDuplicateFromArray {
	// time complexity o(n)
	public static ArrayList<Integer> removeDuplicates(int[] arr) {

		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) { // O(1)
				continue;
			}
			output.add(arr[i]);
			map.put(arr[i], true); // O(1)
		}
		return output;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 3, 3, 2, 4, 5, 2, 3, 1, 1000000, 5, 6 };

		ArrayList<Integer> al = removeDuplicates(arr);

		for (int val : al) {
			System.out.println(val);
		}
		// al.forEach(val -> System.out.println( val ));
	}
}
