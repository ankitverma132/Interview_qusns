import java.util.Arrays;

/*Given a sorted array of positive integers, rearrange the array alternately
 *  i.e first element should be a maximum value, at second position minimum value, 
 *  at third position second max, at fourth position second min, and so on. 

Examples: 

Input: arr[] = {1, 2, 3, 4, 5, 6, 7} 
Output: arr[] = {7, 1, 6, 2, 5, 3, 4}

Input: arr[] = {1, 2, 3, 4, 5, 6} 
Output: arr[] = {6, 1, 5, 2, 4, 3} */

public class rearrange {

	public static void main(String[] args) {
		 int arr[] = new int[] { 1, 2, 3, 4, 5, 6 };
		 
	        System.out.println("Original Array ");
	        System.out.println(Arrays.toString(arr));
	 
	        rearrange(arr, arr.length);
	 
	        System.out.println("Modified Array ");
	        System.out.println(Arrays.toString(arr));

	}
	static void rearrange(int[] arr, int n) {
        // Auxiliary array to hold modified array
        int temp[] = arr.clone();
 
        // Indexes of smallest and largest elements
        // from remaining array.
        int small = 0, large = n - 1;
 
        // To indicate whether we need to copy remaining
        // largest or remaining smallest at next position
        boolean flag = true;
 
        // Store result in temp[]
        for (int i = 0; i < n; i++) {
            if (flag)
                arr[i] = temp[large--];
            else
                arr[i] = temp[small++];
 
            flag = !flag;
        }
    }
}
