/*Priority Queue:
	- Priority Queue Internal Working(Using Heap & Heap properties)
	- Implementation of Max Heap & Min Heap
	- Checking If Array is Max Heap
	- Heap Sort(With Extra space)
	- Inplace Heap sort(Without Extra space : Using Virtual Space)
	- K largest elements of a array
	- Kth largest element of a array*/
	


//Given an array of integers, check whether it represents max-heap or not. 
public class CheckMaxHeap {

	public static void main(String[] args) {
		
		int[] arr = {42, 20, 18, 6, 14, 11, 9, 4};
		System.out.print(checkMaxHeap(arr));

	}
	public static boolean checkMaxHeap(int arr[]) {

		for( int i = 0; i < arr.length; i++ ){
			//Left child
			if( 2*i+1 < arr.length ){
				if( arr[i] < arr[2*i+1] ){
					return false;
				}
			}
			//Right child
			if( 2*i+2 < arr.length ){
				if( arr[i] < arr[2*i+2] ){
					return false;
				}
			}
		}
		return true;        
	}
}
