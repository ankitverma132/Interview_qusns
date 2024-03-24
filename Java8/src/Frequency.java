import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Frequency {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("hello", "hello", "mighty");
		System.out.println(frequencyMap(words.stream()));

	}
	public static Map<String, Long>  frequencyMap(Stream<String> elements) {
		return elements.collect(
				Collectors.groupingBy(
						Function.identity(),
						//HashMap::new, // can be skipped
						Collectors.counting()
						)
				);
	}
}
