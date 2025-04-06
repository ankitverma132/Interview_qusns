import java.util.stream.IntStream;

public class MultiplyAlternate {

	public static void main(String[] args) {
		//  Write a stream program to multiply alternative numbers in an array
		int[] arr = {4,5,1,7,2,9,2};
		//Taking 0 to arr length numbers filtering onlu=y even and then mapping it to array considering it
		//as index and then multiplying them
		int ans = IntStream.range(0, arr.length)
						   .filter(x->x%2==0)
						   .map(x->arr[x])
						   .reduce(1, (a,b)->a*b);
		System.out.println(ans);
		System.out.println("========");
		//16
		
//		The range() method in the IntStream class in Java is used to
//		return a sequential ordered IntStream from startInclusive to endExclusive 
//		by an incremental step of 1. This includes the startInclusive as well.
//		static IntStream range(int startInclusive, int endExclusive)
		
		  IntStream intStream = IntStream.range(20, 30);
	      intStream.forEach(System.out::println);
	}

}
