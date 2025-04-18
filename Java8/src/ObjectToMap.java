import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PersonObject {
	String name;
	String city;
	int age;
	
	public PersonObject(String name, String city, int age) {
		super();
		this.name = name;
		this.city = city;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "PersonObject [name=" + name + ", city=" + city + ", age=" + age + "]";
	}
	
}

public class ObjectToMap {

	public static void main(String[] args) {
		//  Convert a list to a map|
		
		PersonObject p1 = new PersonObject("amit", "Pune", 22);
		PersonObject p2 = new PersonObject("sumit", "kolkata", 27);
		PersonObject p3 = new PersonObject("lalit", "Pune", 23);
		PersonObject p4 = new PersonObject("kapil", "Pune", 28);
		PersonObject p5 = new PersonObject("Danish", "Pune", 28);
		
		List<PersonObject> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.stream().collect(Collectors.groupingBy(PersonObject :: getCity))
				.forEach((k,v)->System.out.println(k + " " + v));

	}

}
