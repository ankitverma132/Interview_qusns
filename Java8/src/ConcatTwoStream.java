import java.util.stream.Stream;

public class ConcatTwoStream {

	public static void main(String[] args) {
		// Concatenate 2 streams
		
		Stream<String> stream1 = Stream.of("Java", "Python");
		Stream<String> stream2 = Stream.of("C", "C++");
		
		
		Stream<String> concatStream = Stream.concat(stream1, stream2);
		concatStream.forEach(System.out::println);
		
//		Java
//		Python
//		C
//		C++


	}

}
