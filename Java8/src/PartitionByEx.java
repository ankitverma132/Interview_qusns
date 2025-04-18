import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee2 {
    String name;
    int age;

    Employee2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
public class PartitionByEx {
	public static void main(String[] args) {
		 
		 List<Integer> numbers = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());

	        // Partition numbers into even and odd
	        Map<Boolean, List<Integer>> partitionedByEvenOdd = 
	            numbers.stream()
	                   .collect(Collectors.partitioningBy(n -> n % 2 == 0));

	        System.out.println("Even Numbers: " + partitionedByEvenOdd.get(true));
	        System.out.println("Odd Numbers: " + partitionedByEvenOdd.get(false));
	   
		 //We can Also Use partitioningBy
	    
//	    Using partitioningBy() for Filtering Collections
//	    The partitioningBy() method offers a convenient way to split a collection into
//	    two distinct groups based on a condition. It returns a Map<Boolean, List<T>>,
//	    where each key-value pair represents the results of applying the predicate to each element.
//	    The keys are true and false, and the values are lists containing elements that satisfy or 
//	    do not satisfy the predicate. This makes the method useful for categorizing data without
//	    needing multiple loops or complex if-else structures.
	//
//	    Here is the basic syntax for using partitioningBy():
	//
//	    Map<Boolean, List<T>> partitionedData = 
//	        stream.collect(Collectors.partitioningBy(predicate));
//	    stream is the original stream of elements.
//	    predicate is a condition that each element is tested against to determine which group 
//	    it belongs to.

			 int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};

		     List<Integer> list = Arrays.stream(intArray)
		             .boxed()
		             .collect(Collectors.toList());
	        Map<Boolean, List<Integer>> map = list.stream()
	        		.collect(Collectors.partitioningBy(x -> x%2 == 0));

	        // Print result as map
	        System.out.println(map);
	        
	        
	        
	        List<Employee2> employees = Arrays.asList(
	                new Employee2("Mason", 25),
	                new Employee2("Olivia", 35),
	                new Employee2("Liam", 28),
	                new Employee2("Sophia", 42),
	                new Employee2("Noah", 22),
	                new Employee2("Isabella", 30)
	            );

	            // Partition employees based on age
	            Map<Boolean, List<Employee2>> partitionedByAge = 
	                employees.stream()
	                         .collect(Collectors.partitioningBy(e -> e.age >= 30));

	            System.out.println("Employees aged 30 and above: " + partitionedByAge.get(true));
	            System.out.println("Employees below 30: " + partitionedByAge.get(false));
	        
	}

	
}
