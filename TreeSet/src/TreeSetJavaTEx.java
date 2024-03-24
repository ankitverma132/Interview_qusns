import java.util.*;
import java.util.stream.Collectors;

/*TreeSet is an implementation of the SortedSet interface in java that uses a red-black tree for storage. 
By default, It maintains an ascending order. 
It contains unique elements only. It doesn’t allow null elements.
Access and retrieval times are quite fast. 
To add the user-defined object into TreeSet, we need to implement a Comparable interface. 
An element that we want to add in TreeSet must be a comparable type.
If we don’t implement the Comparable interface then it will throw ClassCastException. */

class Book implements Comparable<Book> {
	int id;
	String name, author, publisher;
	int quantity;

	public Book(int id, String name, String author, String publisher, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int compareTo(Book b) {
		if (id > b.id) {
			return 1;
		} else if (id < b.id) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class TreeSetJavaTEx {
	public static void main(String[] args) {
		Set<Book> set = new TreeSet<Book>();
		// Creating Books
		Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		// Adding Books to TreeSet
		set.add(b1);
		set.add(b2);
		set.add(b3);
		// Traversing TreeSet
		for (Book b : set) {
			System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}

	}
}