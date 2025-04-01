import java.util.Arrays;
import java.util.List;

public class Distinct {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, null );

		System.out.println("The distinct elements are :");

		// Displaying the distinct elements in the list using Stream.distinct() method

		// The distict() is one such stateful intermediate operation that uses the state 
		// from previously seen elements from the Stream while processing the new items.
		list.stream().distinct().forEach(System.out::println);

	}

}
