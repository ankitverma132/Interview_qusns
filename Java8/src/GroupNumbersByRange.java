import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupNumbersByRange {
	// Given an array of integers, group the numbers by the range
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {2,5,10,14,22,26,34,39,40,41};
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		Map<Integer,List<Integer>> mapListing = list.stream()
				.collect(Collectors.groupingBy(x->(x/10)*10, LinkedHashMap :: new,  Collectors.toList()));
		
		System.out.println(mapListing);
		// {0=[2, 5], 10=[10, 14], 20=[22, 26], 30=[34, 39], 40=[40, 41]}

	}

}
