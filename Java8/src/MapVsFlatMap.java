import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PersonObject2 {
	String name;
	List<String> city;
	
	public PersonObject2(String name, List<String> city) {
		super();
		this.name = name;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getCity() {
		return city;
	}
	public void setCity(List<String> city) {
		this.city = city;
	}
	
}
public class MapVsFlatMap {

	public static void main(String[] args) {
		// Map vs flat map
		List<PersonObject2> list = Arrays.asList(
				new PersonObject2("Alice", Arrays.asList("Kanpur", "Vns")),
				new PersonObject2("Tom", Arrays.asList("Delhi", "Chennai", "Ahmdabad"))
				);
		
		List<List<String>> cityList = list.stream()
				.map(PersonObject2 :: getCity).collect(Collectors.toList());
		System.out.println(cityList);
		
		List<String> flatCityList = list.stream()
				.flatMap(x->x.getCity().stream()).collect(Collectors.toList());
		System.out.println(flatCityList);
	}
}