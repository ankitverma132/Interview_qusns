import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OnlyInteger {
	// Given a list of strings, create a list that contains only integers
	public static void main(String[] args) {
		String[] arr = {"abc", "123", "def", "345"};
		
		//Using regex to filter strings which has only numbers
		List<Integer> ans = Arrays.stream(arr)
						.filter(x -> x.matches("[0-9]+"))
						.map(Integer::valueOf)
						.collect(Collectors.toList());
		System.out.println(ans);
		//[123, 345]
	}

}
