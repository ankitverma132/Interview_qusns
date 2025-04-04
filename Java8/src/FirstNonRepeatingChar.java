import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
	//Given a string, find the first non-repeated character
	public static void main(String[] args) {
		String str = "Hello World";
		String ans = Arrays.stream(str.split(""))
				.filter(c -> str.indexOf(c) == str.lastIndexOf(c))
				.findFirst().get();
		
		System.out.println(ans);
		
		//Method 2
		Map<Character, Long> map = str.chars()
							.mapToObj(c -> (char)c)
							.collect(Collectors.groupingBy(Function.identity(),
									LinkedHashMap :: new,
									Collectors.counting()));
		//Used LinkedHashmap to maintain order
		char ans2 = map.entrySet().stream()
					.filter(entry -> entry.getValue() == 1)
					.map(m -> m.getKey())
					.findFirst().get();
		System.out.println(ans2);

	}

}
