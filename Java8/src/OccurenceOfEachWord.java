import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurenceOfEachWord {
	//Given a sentence, find the occurrence of each word
	public static void main(String[] args) {
		String str = "I am learning Streams API in java java";
		
//		The static factory methods Collectors.groupingBy() provide us with functionality similar 
//		to the ‘GROUP BY’ clause in the SQL language. 
//		We use them for grouping objects by some property and storing results in a Map instance.
		
		
//		You can also group by multiple fields:
//			. Grouping by Multiple Fields
//			A different application of the downstream collector is to do a secondary groupingBy to
//			the results of the first group by.
//
//			To group the List of BlogPosts first by author and then by type:
//
//			Map<String, Map<BlogPostType, List>> map = posts.stream()
//			  .collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));			
		
//		Function.identity() Key Points:
//		- It's often used in scenarios where a function is expected, but you want
//		to make no changes to the data.
//
//			- Commonly utilized in Java Streams, especially with methods like map()
//		when no transformation is required.
//
//			- It returns a singleton instance.
		
		
		
//		The Collectors.counting() method returns a Collector accepting the elements of type T,
//		and counts the number of input elements. The method has the following syntax:
//
//			public static <T> Collector<T,?,Long> counting()
//			The usage of the collector is really straightforward - you just chuck it into the collect() 
//			method.
//			Let's create a "grocery shopping list" with a few items, and then count the number
//			of elements in the list with Collectors.counting():
//
//			List<String> groceryList = Arrays.asList("apples", "milk", "meat", "eggs", "juice");
//			long result = groceryList.stream().collect(Collectors.counting());
//
//			System.out.println(result);
//			This results in:
//
//			5
		Map<String,Long> map = Arrays.stream(str.split(" "))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
	}
}
