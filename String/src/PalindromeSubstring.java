//Palindrome substrings
//Given a string S, count and return the number of substrings of S that are palindrome.
//Single length substrings are also palindromes.
//You just need to calculate the count, not the substrings.
public class PalindromeSubstring {
	
	public static void main(String[] args) {
		System.out.println(countSubstrings("abaab"));
	}
	
	//Using expension
	//Time complexity O(n^2)
	public static int countSubstrings(String s) {
		
		int count = 0;
		for( int i = 0; i < s.length(); i++ ) {
			count += countSubstrings( s, i, i ) 
					+ countSubstrings( s, i, i+1 );
		}
		return count;
	}

	private static int countSubstrings(String s, int i, int j) {
		
		int count = 0;
		while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j) ) {
			//We will simply expand in both direction to count palindromes
			count++;
			i--;
			j++;
		}
		return count;
	}
	
	//Time COmplexity O(n^3)
//	public static void main(String[] args) {
//		
//		String str ="aba";
//		int count = 0;
//		
//		for(int i=0; i<str.length(); i++) {
//	 	    for(int j=i; j<str.length(); j++) {
//			
//	 		boolean flag = isPalindrome(str, i ,j);
////	 		System.out.println(flag);
//	 		if(flag ==true) {
//	 			count++;
//	 		  }
//	 	    }
//		}
//		System.out.println(count);
//	}
//   public static boolean isPalindrome(String str, int a, int b) {
//	   boolean flag = true;
//	   if (b-a==0) {
//		   return true;
//	   }
//	   else {
//		   int i=a, j=b;
//		   while(i<j) {
//			   if(str.charAt(i) != str.charAt(j)) {
//				   flag = false;
//				   break;
//			     }
//			   else {
//				   i++;
//				   j--;
//			   }
//		     }
//	   }
//	   return flag;
//	}
}