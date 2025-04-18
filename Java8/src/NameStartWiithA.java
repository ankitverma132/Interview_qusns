import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NameStartWiithA {

	public static void main(String[] args) {
		// Find name start with A and there count
		List<String> names = Arrays.asList("Ema", "Bob", "Alica", "Anna");
		
		Stream<String> stream1 = names.stream().filter(name->name.startsWith("A"));
		//Using stream 1 once
		stream1.forEach(System.out::println);
//		Alica
//		Anna
		try {
			//Trying to reuse stream1
			long count = stream1.count();
			System.out.println(count);
		}catch(Exception e) {
			System.out.println(e);
		}
//		java.lang.IllegalStateException: stream has already been operated upon or closed

		Stream<String> stream2 = names.stream().filter(name->name.startsWith("A"));
		System.out.println(stream2.count());
		//2
	}
}