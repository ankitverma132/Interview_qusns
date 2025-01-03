/*Print Subsets of Array
Given an integer array (of length n), find and print all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. 
But the order of elements should remain same as in the input array.
Note : The order of subsets are not important. Just print the subsets in different lines.
Input format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
1 <= n <= 15
Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12 */
public class SubsetOfAnArray {
	public static void main(String[] args) {
		int arr[] = { 15, 20, 12 };
		int[] output = new int[0];
		helper(arr, 0, output);
	}
	//Using backtracking
	 private static void helper(int[] A, int i, int[] output) {
			
			if( i == A.length) {
				for(int j =0; j < output.length; j++) {
					System.out.print( output[j] + " ");
			 	}
				System.out.println();
				return;
			}
			//either that subset would not have first element of array
			helper( A, i+1, output );
			int[] newout = new int[output.length+1];
			int k = 0;
			for(int j = 0; j<output.length; j++) {
				newout[k] =  output[j];
				k++;
			}
			//Adding first element to output array
			newout[k] = A[i];
			//or that subset would have first element of array
	    	helper( A, i+1, newout);
		}
}