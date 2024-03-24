/*For a given a string expression containing only round brackets or parentheses,
check if they are balanced or not.
Brackets are said to be balanced if the bracket which opens last, closes first.*/

import java.util.Stack;

public class CheckBalanced {

	public static void main(String[] args) {
		String str = "(()()())";
		System.out.println(checkBalanced(str));

	}
	public static boolean checkBalanced(String exp) {

		Stack<Character> stack = new Stack<>();

		for( int i = 0 ; i < exp.length(); i++ ){
			if( exp.charAt( i ) == '{' || exp.charAt( i ) == '(' || exp.charAt( i ) == '[' ){
				stack.push( exp.charAt(i) );                    
			}  

			else if( exp.charAt( i ) == '}' || exp.charAt( i ) == ')' || exp.charAt( i ) == ']' ){

				if( stack.size() == 0 ){
					return false;
				}
				else{
					if( exp.charAt( i ) == '}') {
						if( stack.peek() == '{' ){
							stack.pop(); 
						}
						else{             
							return false;
						}
					}
					else if( exp.charAt( i ) == ')') {
						if( stack.peek() == '(' ){
							stack.pop(); 
						}
						else{             
							return false;
						}
					}
					else {
						if( stack.peek() == '[' ){
							stack.pop(); 
						}
						else{             
							return false;
						}
					}
				}
			}           
		}  
		return ( stack.size() == 0 )?  true : false;
	}
}