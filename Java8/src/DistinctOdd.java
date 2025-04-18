import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctOdd {

	public static void main(String[] args) {
		//  Find and print the distinct odd numbers
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,9,10);
		List<Integer> ans = list.stream().filter(x->x%2!=0).distinct().collect(Collectors.toList());
		
		System.out.println(ans);
		// [1, 3, 5, 7, 9]
	}
}