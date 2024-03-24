/*You have been given two stacks that can store integers as the data. Out of the two given stacks,
one is populated and the other one is empty.
You are required to write a function that reverses the populated stack using the one which is empty.*/
import java.util.Stack;

public class reverseStack {
	public static void main(String[] args) {
		
		Stack<Integer> s1 = new Stack<>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		
		System.out.println(s1);

		Stack<Integer> s2 = new Stack<>();
		reverseStack(s1,s2);
		
		System.out.println(s1);

	}
	public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {

		if( s1.size() == 0 ){
			return;
		}   
		int temp = s1.pop(); 
		reverseStack( s1, s2);

		while( ! s1.isEmpty() ){         
			s2.push( s1.pop() );            
		}  
		s1.push( temp );
		while( ! s2.isEmpty() ){         
			s1.push( s2.pop() );            
		}    
	}
}