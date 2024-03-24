
public class PushZeroAtOneEnd {

	public static void main(String[] args) {

		int arr[] = { 2, 0, 6, 0, 0, 2, 0, 28 };
		pushZerosAtEnd(arr);

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);
		}
	}

	public static void pushZerosAtEnd(int[] arr) {
		int i = 0;
		int j = arr.length - 1;

		while(i<j) {
			if(arr[i] != 0) {
				i++;
			}
			if(arr[j] == 0 ) {
				j--;
			}
			if(arr[i] == 0 && arr[j] > 0){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
	}
}