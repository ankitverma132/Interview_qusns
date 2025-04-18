import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToUppercasee {

	public static void main(String[] args) {
		// Convert a list of strings to uppercase
		List<String> list = Arrays.asList("abc","def", "breaking bad");
		
		List<String> ans = list.stream().map(String ::toUpperCase).collect(Collectors.toList());
		System.out.println(ans);
		// [ABC, DEF, BREAKING BAD]

	}

}
