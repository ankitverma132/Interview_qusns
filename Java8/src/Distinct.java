import java.util.Arrays;
import java.util.List;

public class Distinct {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, null );

		System.out.println("The distinct elements are :");

		// Displaying the distinct elements in the list using Stream.distinct() method
		list.stream().distinct().forEach(System.out::println);

	}

}
