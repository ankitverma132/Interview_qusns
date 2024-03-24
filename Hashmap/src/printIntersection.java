//Print Intersection
//Given two random integer arrays, print their intersection. 
//That is, print all the elements that are present in both the given arrays.
//Input arrays can contain duplicate elements.
//Sample Input 1 :
//6
//2 6 8 5 4 3
//4
//2 3 4 7 
//Sample Output 1 :
//2 
//4 
//3
//Sample Input 2 :
//4
//2 6 1 2
//5
//1 2 3 4 2
//Sample Output 2 :
//2 
//2
//1
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class printIntersection {
	//O(nlogn + mlogm)
	public static void intersection(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int i = 0; 
		int j = 0;
		
		while( i < arr1.length  && j < arr2.length ) {
			if(arr1[i] == arr2[j]) {
				System.out.println(arr1[i]);
				i += 1;
				j += 1;
			}else if(arr1[i] > arr2[j]) {
				j += 1;
			}else {
				i += 1;
			}
		}
	}
	
	/*
	 * The algorithm of the intersection of the array using hashmap is as follow:
	 * 
	 * Build the hashmap for the nums1, that is, count the frequency of each
	 * element. Traverse each element of nums2, one by one. If the element is
	 * present in the map formed in step 1, reduce the frequency of the element by 1
	 * and print the element, if the frequency becomes 0, remove the element from
	 * the map. Repeat step 3 for all elements of nums2.
	 */
	//Using HashMap	O(n+m)
	public static void intersectionUsingHashmap(int[] arr1, int[] arr2){
		
		HashMap<Integer, Integer> map1 = new HashMap<>();
		for( int i = 0; i < arr1.length; i++ ) {
			
			if( map1.containsKey(arr1[i]) ) {
				map1.put(arr1[i], map1.get(arr1[i]) + 1 );
			}
			else {
				map1.put(arr1[i], 1);
			}
		}
		
		HashMap<Integer, Integer> map2 = new HashMap<>();
		for( int i = 0; i < arr2.length; i++ ) {
			
			if( map2.containsKey(arr2[i]) ) {
				map2.put(arr2[i], map2.get(arr2[i]) + 1 );
			}
			else {
				map2.put(arr2[i], 1);
			}
		}
		
		Set<Integer> keys = map1.keySet();
		for( int key : keys ) {
			if( map2.containsKey(key) ) {
				for( int i = 0; i < Math.min(map1.get(key), map2.get(key)); i++ ) {
					System.out.println(key);
				}
			}
		}

	}	
	public static void main(String[] args) {
		
		int arr1[] = {2,6,1,2};
		int arr2[] = {1,2,3,4,2};
		intersection( arr1, arr2 );
	}
}