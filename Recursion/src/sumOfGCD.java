public class sumOfGCD {

	public static int sumOfGCD( int num ) {
		int sum = 0;
		for( int i = 1; i <= num; i++ ) {
			sum = sum + gcd( i, num);
		}
		return sum;
	}
	
	private static int gcd(int a, int b) {

		if( a == b ) {
			return a;
		}
		else if( a > b ) {
			return gcd( a - b, b );
		}
		else {
			return gcd( a, b-a );
		}
	}

	public static void main(String[] args) {
		System.out.println( sumOfGCD(12));		
	}
}