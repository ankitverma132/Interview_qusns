import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductOfFirstTwoElement {

	public static void main(String[] args) {
		// Find the products of the first two elements in an array
		int[] arr = {2,9,10,3,7};
		int ans = Arrays.stream(arr).boxed()
						.collect(Collectors.toList())
						.stream().limit(2).reduce(1,(a,b)->a*b);
		
		System.out.println(ans);
		//18
	}

}
