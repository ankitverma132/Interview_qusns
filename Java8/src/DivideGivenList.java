import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DivideGivenList {
	// Divide given integer list into lists of even and odd numbers
	public static void main(String[] args) {
		 int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
		 
//		 boxed method:
//			 The boxed method is used to convert a stream of primitive values (like IntStream, DoubleStream, LongStream)
//			 into a stream of their corresponding wrapper classes (e.g., Integer, Double, Long).
//			 It’s often used when you have a stream of primitive values, and you want to work with 
//			 them as objects in situations where object-oriented features are needed.
//		 boxed() is specifically for converting a primitive stream to a stream of boxed objects.

	        // Using boxed to convert IntStream to Stream<Integer>
		 
	        List<Integer> list = Arrays.stream(intArray)
	                                           .boxed()
	                                           .collect(Collectors.toList());
	        // Print the list of boxed integers
	        System.out.println(list);
	        
	        Map<Boolean, List<Integer>> map = list.stream()
	        		.collect(Collectors.groupingBy(x -> x%2 == 0, Collectors.toList()));

	        // Print result as map
	        System.out.println(map);
	        
	        List<List<Integer>> listOfLists = list.stream()
	        		.collect(Collectors.groupingBy(x -> x%2 == 0, Collectors.toList()))
	        		.entrySet().stream().map(entry -> entry.getValue())
	        		.collect(Collectors.toList());
	        
	        // Print result as list of lists
	        System.out.println(listOfLists);
	        
	        
	        //We can Also Use partitioningBy
	        
//	        Using partitioningBy() for Filtering Collections
//	        The partitioningBy() method offers a convenient way to split a collection into
//	        two distinct groups based on a condition. It returns a Map<Boolean, List<T>>,
//	        where each key-value pair represents the results of applying the predicate to each element.
//	        The keys are true and false, and the values are lists containing elements that satisfy or 
//	        do not satisfy the predicate. This makes the method useful for categorizing data without
//	        needing multiple loops or complex if-else structures.
//
//	        Here is the basic syntax for using partitioningBy():
//
//	        Map<Boolean, List<T>> partitionedData = 
//	            stream.collect(Collectors.partitioningBy(predicate));
//	        stream is the original stream of elements.
//	        predicate is a condition that each element is tested against to determine which group 
//	        it belongs to.
	        
	        
	        
	        List<List<Integer>> listOfLists2 = list.stream()
	        		.collect(Collectors.partitioningBy(x -> x%2 == 0, Collectors.toList()))
	        		.entrySet().stream().map(entry -> entry.getValue())
	        		.collect(Collectors.toList());
	        
	        // Print result as list of lists
	        System.out.println(listOfLists2);
	}
}
