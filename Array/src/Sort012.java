public class Sort012 {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 0, 2, 0, 1 };
		sort012(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void sort012(int[] arr) {

		int i = 0, nZ = 0, nT = arr.length - 1, temp = 0;
		// Here nz represnting position where next 0 would be stored
		// and nT represents where next 2 will be stored.
		while (i <= nT) {
			if (arr[i] == 0) {
				temp = arr[i];
				arr[i] = arr[nZ];
				arr[nZ] = temp;
				i++;
				nZ++;
			} else if (arr[i] == 2) {
				temp = arr[i];
				arr[i] = arr[nT];
				arr[nT] = temp;
				nT--;
			} else {
				i++;
			}
		}
	}
}