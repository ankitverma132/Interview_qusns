import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
public class sortElementsByFreq {

	public static void main(String[] args) {
		Integer[] arr = { 2, 5, 2, 8, 5, 6, 8, 8 };

        List<Integer> list = Arrays.asList(arr);
        sortBasedOnFrequencyAndValue(list);
	}

	private static void sortBasedOnFrequencyAndValue(List<Integer> list) {

		int n = list.size();
		final HashMap<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
		final HashMap<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			if (mapCount.containsKey(list.get(i))) {
				mapCount.put(list.get(i), mapCount.get(list.get(i)) + 1);
			} else {
				mapCount.put(list.get(i), 1); // Map to capture Count of elements
				mapIndex.put(list.get(i), i); // Map to capture 1st occurrence of elements
				//If 2 elements have same frequency they will be sorted on basis of there occurence
			}
		}

		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer n1, Integer n2) {
				
				int freq1 = mapCount.get(n1);
				int freq2 = mapCount.get(n2);
				
				if (freq1 != freq2) {
					return freq2 - freq1;
				} else {
					return mapIndex.get(n1) - mapIndex.get(n2); // Elements with Lesser
																// Index gets Higher
																// Priority
				}
			}
		});
		System.out.println(list);
	}
}