
public class fibonacci {
	//0 1 1 2 3 5 8 13 21 24.........
	
	//Using recursion
	public static int fib( int n ) {   //Time complexity O(2^n)
		if( n == 0 || n == 1 ) {
			return n;
		}
		return fib( n-1 ) + fib( n-2 );
	}
//---------------------------	
	//Using Memoization(Top to down approach)
	public static int fibM( int n ) {   //Time complexity O(n)
		
		int storage[] = new int[n+1];
		for( int i = 0; i < storage.length; i++ ) {
			storage[i] = -1;
		}
        return fibM( n, storage );		
	}
	
	private static int fibM(int n, int[] storage) {
		if( n == 0 || n == 1 ) {
			storage[n] = n;
			return storage[n];
		}
		if( storage[n] != -1 ) {
			return storage[n];
		}
	    storage[n] = fibM( n-1, storage ) + fibM( n-2, storage );
		return storage[n];
	}
//------------------------------	
	//Using DP(Bottom to Top approach)
	public static int fibDP( int n ) {   //Time complexity O(n)
		
		int storage[] = new int[n+1];
		storage[0] = 0; 
		storage[1] = 1; 
		for( int i = 2; i <=n ; i++ ) {
			storage[i] = storage[i-1] + storage[i-2];
		}
        return storage[n];		
	}
//------------------------------	
	
	public static void main(String[] args) {
		
		System.out.println( fibDP(20) );	
		System.out.println( fibM(20) );
		System.out.println( fib(20) );		
	}
}