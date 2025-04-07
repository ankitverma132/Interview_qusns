import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoveZeroInFront {
	// Write a stream program to move all zero’s to beginning of array
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,0,1,8,0,0,7};
		
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		//Method 1: create a list of zero and an list og no-zeros and merge them

		List<Integer> listOfZeros = list.stream().filter(x -> x == 0).collect(Collectors.toList());
		List<Integer> listOfNonZeros = list.stream().filter(x -> x != 0).collect(Collectors.toList());
		
		List<Integer> finalList = new ArrayList<>();
		finalList.addAll(listOfZeros);
		finalList.addAll(listOfNonZeros);
		
		System.out.println(finalList);
		//[0, 0, 0, 5, 1, 8, 7]
		
		//Method 2: using partioningBy
		
		
		Map<Boolean, List<Integer>> map = list.stream()
								.collect(Collectors.partitioningBy(x -> x != 0));
		// {false=[0, 0, 0], true=[5, 1, 8, 7]}
		System.out.println(map);
		
		Collection<List<Integer>> collection = map.values();
		System.out.println(collection);
		//[[0, 0, 0], [5, 1, 8, 7]]
		
		// Use flat map
		List<Integer> ans = collection.stream()
							.flatMap(x -> x.stream())
							.collect(Collectors.toList());
		System.out.println(ans);
		
//		The Stream.flatMap() method in Java is used to transform each element of a stream 
//		into another stream and then merge all those streams into a single stream. 
//		It is helpful when working with nested data structures, like lists within lists.
//		
//		Stream<List<Integer>> integerListStream = Stream.of(
//			    Arrays.asList(1, 2), 
//			    Arrays.asList(3, 4), 
//			    Arrays.asList(5)
//			);
//
//		Stream<Integer> integerStream = integerListStream .flatMap(Collection::stream);
//		integerStream.forEach(System.out::println);
//			1
//			2
//			3
//			4
//			5	
	}

}
