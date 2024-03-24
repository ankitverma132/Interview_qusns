//Rearrange positive and negative numbers in O(n) time and O(1) extra space
//An array contains both positive and negative numbers in random order.
//Rearrange the array elements so that positive and negative
//numbers are placed alternatively. Number of positive and negative
//numbers need not be equal. If there are more positive numbers 
//they appear at the end of the array. If there are more negative
//numbers, they too appear in the end of the array.
//
//For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
//then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]

public class rearrangePosNegNum {

	//Time complexity o(n) space complexity O(1)
	private static void rearrange(int[] arr, int n) {
		
		//first placing all positive numbers at 
		//start and all negative numbers at end
		int i = 0;
		int j = arr.length-1;
		
		while( i < j ) {
			if( arr[i] < 0 && arr[j] > 0 ) {
				//Swap
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			if( arr[i] > 0 ) {
				i++;
			}
			if( arr[j] < 0 ) {
				j--;
			}
		}
		//Here all positive numbers would be at start and negative at end 
		int k = 0;
		//Place a pointer k at first negative number
		while( arr[k] > 0 ) {
			k++;
		}
		int m = 1;
		while( k < arr.length ) {
			int temp = arr[k];
			arr[k] = arr[m];
			arr[m] = temp;
			k++;
			m += 2;
		}
	}
	
	public static void main(String[] args) {

		 int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9}; 
	     int n = arr.length; 
	     rearrange(arr,n); 
	     for( int i = 0; i < arr.length; i++ ){			
				System.out.println( arr[i] );
	     }
	}
}