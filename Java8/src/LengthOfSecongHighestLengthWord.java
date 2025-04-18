import java.util.Arrays;
import java.util.Comparator;

public class LengthOfSecongHighestLengthWord {
	public static void main(String[] args) {
		String str = "I am learning Streams API in java";
        int ans = Arrays.stream(str.split(" ")).map(word -> word.length())
        				   .sorted(Comparator.reverseOrder())
        				   .skip(1).findFirst().get();
        System.out.println(ans);
	}
}
