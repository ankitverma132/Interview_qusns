
public class bubbleSort {

	private static void bubbleSort(int[] arr) {
		
		//In bubble sort after each iteration last element will be largest
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]) {
					//Swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(int i = 0; i < arr.length; i++ ) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {

		int[] arr = {3,5,7,1,2};
		bubbleSort(arr);
	}
}
