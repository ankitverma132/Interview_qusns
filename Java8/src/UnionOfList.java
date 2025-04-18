import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnionOfList {

	public static void main(String[] args) {
		//  Find the union of two lists of integers
		

		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
		List<Integer> list2 = Arrays.asList(6,7,8,9,10);

		
		List<Integer> ans = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
		System.out.println(ans);
		//[1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10]
		
//		The Java 8 Stream.concat() method merges two streams into one stream. The combined stream 
//		consists of all the elements of both streams.
//
//		If either of the streams is a parallel stream, the resulting stream will also be a parallel stream. 
//		Be careful when combining parallel and sequential streams because this may affect performance
//		and behavior.
//
//		The concat() method is useful in the following usecases:
//
//		Combining results from different data sources.
//		Merging multiple streams into one for unified processing.
//		Concatenating static data with dynamically generated data.
//		1. Stream concat() Method
//		The concat() method is a static method in Stream class. Its method signature is:
//
//		static <T> Stream<T> concat(Stream<? extends T> firstStream, Stream<? extends T> secondStream)
//
//		It creates a lazily concatenated stream whose elements are all the elements of the firstStream
//		followed by all the elements of the secondStream.
//		The resulting stream is ordered if both of the input streams are ordered.
//		The resulting stream is parallel if either of the input streams is parallel.
//		When the resulting stream is closed, the close handlers for both input streams are invoked.
//		2. Merge Two Streams using Stream.concat()
//		Java example to merge two streams of numbers – to obtain a stream that contains numbers
//		from both streams.
//
//		Stream<Integer> firstStream = Stream.of(1, 2, 3);
//		Stream<Integer> secondStream = Stream.of(4, 5, 6);
//		 
//		Stream<Integer> resultingStream = Stream.concat(firstStream, secondStream);
//		 
//		System.out.println( resultingStream.toList() );   
//
//		Program Output.
//
//		[1, 2, 3, 4, 5, 6]
//
//		3. Combining Multiple Streams using Stream.concat()
//		Java example to merge four streams of numbers – to obtain a stream that contains numbers
//		from all streams. Notice we have made a static import to Stream.concat() function which makes
//		the code readable.
//
//		Stream<Integer> first = Stream.of(1, 2);
//		Stream<Integer> second = Stream.of(3,4);
//		Stream<Integer> third = Stream.of(5, 6);
//		Stream<Integer> fourth = Stream.of(7,8);
//
//		Stream<Integer> resultingStream = Stream.concat(first, concat(second, concat(third, fourth)));
//
//		System.out.println( resultingStream.toList() );
//
//		Program Output.
//
//		[1, 2, 3, 4, 5, 6, 7, 8]
	}

}
