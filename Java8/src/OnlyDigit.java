import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OnlyDigit {

	public static void main(String[] args) {
		//  Find and print strings containing only digits.
		List<String> list = Arrays.asList("abc","456", "1a2b3c", "123abc", "123");
		
		List<String> ans = list.stream()
				.filter(x->x.matches("[0-9]+")).collect(Collectors.toList());
		System.out.println(ans);
		// [456, 123]
	}

}
