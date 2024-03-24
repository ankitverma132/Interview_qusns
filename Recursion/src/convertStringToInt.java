
public class convertStringToInt {

	public static void main(String[] args) {

		System.out.println(convertStringToIntMethodTwo("1234"));
	}

	private static int convertStringToInt(String input) {

		if (input.length() == 1) {
			return input.charAt(0) - '0';
		}

		int smallAns = convertStringToInt(input.substring(0, input.length() - 1));
		int lastDigit = input.charAt(input.length() - 1) - '0';
		return smallAns * 10 + lastDigit;
	}
	
	private static int convertStringToIntMethodTwo(String input) {

		int num = 0; 
	    int n = input.length(); 
	  
	    // Iterate till length of the string 
	    for(int i = 0; i < n; i++) 
	  
	        // Subtract 48 from the current digit 
	        num = num * 10 + ((int)input.charAt(i) - '0'); 
	  
	    return num; 
	}
}