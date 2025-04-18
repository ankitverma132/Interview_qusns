import java.util.Arrays;
import java.util.List;

public class NumberSum {

	public static void main(String[] args) {
		// Find the sum of all the elements in a list.
//		mapToInt() is used to convert objects within a stream into integers.
//		This is particularly useful for transforming streams 
//		where you need to perform numerical calculations or aggregate operations on integer values.
		
//		mapToInt() converts each element of a stream to an integer using a provided int-producing function.
//
//		2. It returns an IntStream, which is a stream of primitive int values, allowing for
//		operations that are more efficient than those on a Stream<Integer>.
//
//		3. This method is commonly used for operations like summing, finding min or max, or 
//		averaging, which require integer values.
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		// 15
	}

}
