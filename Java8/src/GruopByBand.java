/*@Getter
@Setter
public class Employee{
  private Integer age;    // 0 to 150
  private String gender; // M, F
  private Integer salary; // 10000 - 250000 USD
  private String band; // A, B, C, D
}

Employee e1 = new Employee(25, "M", 25000, "D");
Employee e2 = new Employee(35, "M", 48000, "C");
Employee e3 = new Employee(28, "M", 29000, "B");
Employee e4 = new Employee(44, "M", 60000, "B");
Employee e5 = new Employee(50, "M", 125000, "A");
Employee e6 = new Employee(28, "M", 29000, "B");
Employee e7 = new Employee(44, "M", 60000, "B");
Employee e8 = new Employee(50, "M", 125000, "A");
Employee e9 = new Employee(23, "F", null, null);
Employee e10 = new Employee(46, "M", 150000, "A");

List<Employee> employeeList = List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

// Get all employees of same BAND added to a list and
// add all unique BANDS to a Map. (Map of Lists)
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GruopByBand {

	public static void main(String[] args) {

		Emp e1 = new Emp(25, "M", 25000, "D");
		Emp e2 = new Emp(35, "M", 48000, "C");
		Emp e3 = new Emp(28, "M", 29000, "B");
		Emp e4 = new Emp(44, "M", 60000, "B");
		Emp e5 = new Emp(50, "M", 125000, "A");
		Emp e6 = new Emp(28, "M", 29000, "B");
		Emp e7 = new Emp(44, "M", 60000, "B");
		Emp e8 = new Emp(50, "M", 125000, "A");
		Emp e9 = new Emp(23, "F", null, null);
		Emp e10 = new Emp(46, "M", 150000, "A");

		List<Emp> empList = List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
		
		Map<String,List<Emp>> empByBand = new HashMap<>();  
		//GroupingBy creates issue with null keys so filtering null keys first
		empByBand =  empList.stream().filter(p -> p.getBand() != null).collect(Collectors.groupingBy(Emp::getBand));  
        System.out.println("Employees grouped by cities in Java 8: " + empByBand); 
	}

}

class Emp{
	private Integer age;    // 0 to 150
	private String gender; // M, F
	private Integer salary; // 10000 - 250000 USD
	private String band; // A, B, C, D
	public Emp(Integer age, String gender, Integer salary, String band) {
		super();
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.band = band;
	}
	public Integer getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Emp [age=" + age + ", gender=" + gender + ", salary=" + salary + ", band=" + band + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, band, gender, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return Objects.equals(age, other.age) && Objects.equals(band, other.band)
				&& Objects.equals(gender, other.gender) && Objects.equals(salary, other.salary);
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
}
