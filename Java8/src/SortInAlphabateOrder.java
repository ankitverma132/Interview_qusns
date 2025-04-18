import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortInAlphabateOrder {

	public static void main(String[] args) {
		// Sort a list of strings in alphabetical order 
		
		List<String> list = Arrays.asList("zudio", "puma", "addidas", "mac" );
		List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
		
		System.out.println(sortedList);

	}

}
