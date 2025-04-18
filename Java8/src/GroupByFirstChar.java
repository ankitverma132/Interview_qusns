import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByFirstChar {

	public static void main(String[] args) {
		// Group list of strings by their first character and count the number of strings
		
		
		List<String> fruits = Arrays.asList("apple", "banana", "apricot", "cherry", "avacado");
		
		Map<Character, Long> map = fruits.stream()
				.collect(Collectors.groupingBy(x->x.charAt(0), Collectors.counting()));
		
		System.out.println(map);
		
		//{a=3, b=1, c=1}

	}

}
