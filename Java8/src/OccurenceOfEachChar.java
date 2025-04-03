import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurenceOfEachChar {

	public static void main(String[] args) {

		String str = "Missing";
	    Map<String,Long> ans = Arrays.stream(str.split(""))
	    				   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    
//		Or
//	    Map<String,Long> ans = Arrays.stream(str.split(""))
//	    				   .collect(Collectors.groupingBy(x->x, Collectors.counting()));
	    
	    
	    System.out.println(ans);
	}
}
