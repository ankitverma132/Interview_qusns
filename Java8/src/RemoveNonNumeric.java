import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RemoveNonNumeric {

	public static void main(String[] args) {
		//  Remove all non-numeric characters from a list.
		List<String> list = Arrays.asList("a1b2c3", "1a2b3c", "123abc");
		Pattern pat = Pattern.compile("[^0-9]");//Pattern for not a number
		
		List<String> ans = list.stream()
				.map(x->pat.matcher(x).replaceAll("")).collect(Collectors.toList());
		System.out.println(ans);
		// [123, 123, 123]

	}
}
