import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

class Person {
	private String name;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Person(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
}
public class OccuranceOfDomain {

	public static void main(String[] args) {
		// Find the occurrence of domains using Java streams 
		Person e1 = new Person("abc","abc@gmail.com");
		Person e2 = new Person("def","def@gmail.com");
		Person e3 = new Person("ghi","ghi@yahoo.com");
		
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(e1);
		persons.add(e2);
		persons.add(e3);
		
		System.out.println(
				persons.stream()
				.map(x -> x.getEmail().substring(x.getEmail().indexOf('@')))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				);
		// {@gmail.com=2, @yahoo.com=1}
	}
}
