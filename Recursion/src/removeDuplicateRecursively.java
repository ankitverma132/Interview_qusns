public class removeDuplicateRecursively {

	public static String removeConsecutiveDuplicates(String s) {
		
        return helper( s, 0 );
	}
    public static String helper( String s, int i ){
        
        if( i == s.length()-1 ){
              return Character.toString( s.charAt(i) );         
        }
        String smallAns = helper( s, i+1 );
        if( s.charAt(i) != smallAns.charAt(0)){
           return s.charAt(i) + smallAns ;
        }
        else{
            return smallAns ;    
        }   
    } 
    
    public static void main(String[] args) {
    	String str = "xxxyyyzwwzzz";
    	System.out.println(removeConsecutiveDuplicates(str));
    }
}