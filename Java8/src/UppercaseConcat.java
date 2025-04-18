import java.util.Arrays;
import java.util.List;

public class UppercaseConcat {

	public static void main(String[] args) {
		//  Convert a list of string to uppercase and then concatenate
		
		List<String> list = Arrays.asList("a", "b", "c", "d");
		
		String ans = list.stream().map(String::toUpperCase)
						.reduce((s1,s2)-> s1+ " " + s2).orElse("");
		System.out.println(ans);
	}

}
