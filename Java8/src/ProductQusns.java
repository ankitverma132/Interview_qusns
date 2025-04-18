import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Product {
	int id;
	String brand;
	double price;
	String name;
	public Product(int id, String brand, double price, String name) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double discPrice) {
		this.price = discPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", price=" + price + ", name=" + name + "]";
	}
	
	
}
public class ProductQusns {

	public static void main(String[] args) {

		Product p1 = new Product(1,"Lifeboy", 22, "Soap");
		Product p2 = new Product(2,"Portronic", 25, "Adapter");
		Product p3 = new Product(3,"Surfexcel", 30, "Washing powder");
		Product p4 = new Product(4,"Yamha", 40, "Bike");
		Product p5 = new Product(5,"Ikige", 50, "Book");
		
		List<Product> list = Arrays.asList(p1,p2,p3,p4,p5);
		
		//Print products having price less then 40
		List<Product> filteredProd = list.stream()
				.filter(x->x.getPrice()<40).collect(Collectors.toList());
		
		System.out.println(filteredProd);
		//create new list of product with 20% discount
		
		List<Product> newList = list.stream().map(prod -> {
			double discPrice = prod.getPrice()*0.80;
			prod.setPrice(discPrice);
			return prod;
		}).collect(Collectors.toList());
		System.out.println(newList);
		
		
		//Calculate average price of all product
		Double avgPrice = list.stream().mapToDouble(Product::getPrice).average().getAsDouble();
		System.out.println(avgPrice);
		
		//Find lowest price
		Optional<Product> lowestPriceProd = list.stream()
				.min((x1,x2)->Double.compare(x1.getPrice(), x2.getPrice()));
		if(lowestPriceProd.isPresent()) {
			System.out.println(lowestPriceProd.get());
		}
		
		
//		[Product [id=1, brand=Lifeboy, price=22.0, name=Soap], Product [id=2, brand=Portronic, price=25.0, name=Adapter], Product [id=3, brand=Surfexcel, price=30.0, name=Washing powder]]
//		[Product [id=1, brand=Lifeboy, price=17.6, name=Soap], Product [id=2, brand=Portronic, price=20.0, name=Adapter], Product [id=3, brand=Surfexcel, price=24.0, name=Washing powder], Product [id=4, brand=Yamha, price=32.0, name=Bike], Product [id=5, brand=Ikige, price=40.0, name=Book]]
//		26.72
//		Product [id=1, brand=Lifeboy, price=17.6, name=Soap]
	}
}
