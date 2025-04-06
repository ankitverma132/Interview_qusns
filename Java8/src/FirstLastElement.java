import java.util.stream.IntStream;

public class FirstLastElement {

	public static void main(String[] args) {
		//  Write a program to multiply 1st and last element, 2nd and 2nd last element etc.
		int[] arr = {4,5,1,7,2,9};
		//o/p - 36 10 7
		
		IntStream.range(0, arr.length/2)
				.map(x->arr[x]*arr[arr.length-x-1])
				.forEach(System.out::println);
//		36
//		10
//		7
	}
}
