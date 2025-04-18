import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToSquares {

	public static void main(String[] args) {
		// Convert a list of integers to a list of their squares
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		
		List<Integer> square = list.stream().map(x->x*x).collect(Collectors.toList());
		System.out.println(square);

	}

}
