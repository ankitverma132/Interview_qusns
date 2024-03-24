public class mergeSort {

	public static void main(String[] args) {

		int A[] = { 4, 5, 9, 2, 8 };      
		mergeSort(A);
		for(int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
	//Time complexity O(nlogn)
	private static void mergeSort(int[] A) {

		mergeSortHelper(A, 0, A.length-1 );
	}

	public static void mergeSortHelper(int[] input, int SI, int EI){
		
		if(SI >= EI) {
			return;
		}
		
		int mid = (SI+EI)/2;
		
		mergeSortHelper(input, SI, mid );
		mergeSortHelper(input, mid+1, EI);
		merge(input, SI, EI);
	}

	private static void merge(int[] input, int sI, int eI) {

		int mid = ( sI + eI )/2;
		
        int ans[] = new int[ eI-sI+1 ];	
        int i = sI;
        int j = mid+1;
        int k = 0;
        while( i <= mid && j <= eI) {
        	if(input[i] < input[j]) {
        		ans[k] = input[i];
        		i++;
        		k++;
        	}
        	else {
        		ans[k] = input[j];
        		k++;
        		j++;
        	}
        }
        while(i <= mid) {
        	ans[k] = input[i];
        	i++;
        	k++;
        }
        while(j <= eI) {
        	ans[k] = input[j];
        	k++;
        	j++;
        }
        for(int index = 0; index < ans.length; index++) {
        	input[sI + index] = ans[index];
        }		
	}
}