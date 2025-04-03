import java.util.Arrays;
import java.util.Collections;

public class ArrangeNumbers {
//	Arrange the numbers in Descending/Ascending Order
	public static void main(String[] args) {

		 int[] arr = {3, 2, 5, 4, 7, 6, 1, 8};
		 
		 Arrays.stream(arr).mapToObj(x->x).sorted().forEach(System.out::println);
		 System.out.println("=========================");
		 Arrays.stream(arr).mapToObj(x->x).sorted(Collections.reverseOrder()).forEach(System.out::println);
	}

}
