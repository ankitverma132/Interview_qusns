import java.util.Arrays;
import java.util.List;

public class KthSmalles {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(7,1,5,2,1,3,4,5);
		int k = 3;
		
		int ans = list.stream().sorted().skip(k-1).findFirst().get();
		System.out.println(ans);
	}
}
