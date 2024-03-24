import java.util.stream.Stream;

public class OddNumbers {

	public static void main(String[] args) {
		
		Stream.iterate(0, n -> n+1)
			  .filter(x -> x%2 != 0)
			  .limit(10)
			  .forEach(System.out :: println);
	}
}