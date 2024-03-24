/*Maximum Square Matrix With All Zeros
Given an NxM matrix that contains only 0s and 1s, find out the size of the maximum square sub-matrix with all 0s.
You need to return the size of the square matrix with all 0s.
Input format :
The first line of the test case contains two integer values, 'N' and 'M', separated by a single space.
They represent the 'rows' and 'columns' respectively.
Second-line onwards, the next 'N' lines or rows represent the ith row values.
Each of the ith rows constitutes column values separated by a single space (Either 0 or 1).
Output Format:
Print the size of maximum square sub-matrix.
Sample Input 1:
3 3
1 1 0
1 1 1
1 1 1
Sample Output 1:
1
Sample Input 2:
4 4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
Sample Output 2:
4*/
public class findMaxSquareWithAllZeros {

	public static void main(String[] args) {

	}
	public static int findMaxSquareWithAllZeros(int[][] input){

		int m = input.length;
		int n = input[0].length;
		//This array will store length of squares ending at index i,j
		int storage[][] = new int[m][n];

		//Filling first row and first col
		for( int i = 0; i < m; i++ ) {
			if( input[i][0] == 0 ) {
				storage[i][0] = 1;
			} else {
				storage[i][0] = 0;
			}
		}
		for( int i = 0; i < n; i++ ) {
			if( input[0][i] == 0 ) {
				storage[0][i] = 1;
			} else {
				storage[0][i] = 0;
			}
		}

		for( int i = 1; i < m; i++ ) {
			for( int j = 1; j < n; j++ ) {
				if( input[i][j] == 1) {
					storage[i][j] = 0;
				}
				else {
					storage[i][j] = 1 + Math.min(storage[i-1][j-1],
							Math.min(storage[i-1][j], storage[i][j-1]) );
				}
			}
		}
		int maxSquare = Integer.MIN_VALUE;
		for( int i = 0; i < m; i++ ) {
			for( int j = 0; j < n; j++ ) {
				if( storage[i][j] > maxSquare ) {
					maxSquare = storage[i][j];
				}
			}
		}
		return maxSquare;
	}
}