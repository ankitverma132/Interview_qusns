
// Java program to loop over TreeSet
// Needful libraries
import java.util.TreeSet;
import java.util.stream.Collectors;

public class iterateOverTreeSet {
	public static void main(String[] args) {
		// TreeSet object
		TreeSet<Integer> ts = new TreeSet<Integer>();

		// Adding elements to the TreeSet
		ts.add(10);
		ts.add(61);
		ts.add(87);
		ts.add(39);

		// Loop over the TreeSet & print values
		System.out.print("TreeSet without Comma: ");

		// Iterating through the TreeSet
		// using forEach
		ts.forEach(i -> System.out.print(i + " "));
		System.out.println();

		// Loop over the TreeSet & print values
		System.out.print("TreeSet with Comma: ");

		// Iterating through the TreeSet
		// using stream
		System.out.print(ts.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(", ")));
	}
}