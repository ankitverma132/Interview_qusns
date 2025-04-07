import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IsDistinctvalues {

	public static void main(String[] args) {
		//  In a given array of integers, return true if it contains distinct values
		int[] arr = {5,0,1,8,0,0,7};
		
		//False as zero is repeated

		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		Map<Integer,Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		//{0=3, 1=1, 5=1, 7=1, 8=1}
		Collection<Long> collection = map.values();
		boolean ans = collection.stream().noneMatch(x->x>1);
		System.out.println(ans);
		//false
		
		// nonMatch():
//		The noneMatch() is a short-circuiting terminal operation.
//		It returns whether no element of the stream match the provided predicate.
		//boolean noneMatch(Predicate<? super T> predicate)
//		true – if no element in the stream matches the given predicate, or the stream is empty.
//		false – if at least one element matches the given predicate.
	
	}

}
