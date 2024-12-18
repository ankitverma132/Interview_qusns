
/*Given k different arrays, which are sorted individually (in ascending order).
You need to merge all the given arrays such that output array should be sorted (in ascending order).
Sample Input 1:
4
3
1 5 9
2
45 90
5
2 6 78 100 234
1
0
Sample Output 1:
0 1 2 5 6 9 45 78 90 100 234*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class triplet {
	int element;
	int arrayIndex;
	int elementIndex;
}
class tripletComparator implements Comparator<triplet>{
	@Override
	public int compare( triplet o1, triplet o2) {

		if( o1.element < o2.element ) {
			return -1;
		}
		else if( o1.element > o2.element ) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
public class MergeKSortedArrays {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = (ArrayList<Integer>) Arrays.asList(1,5,9);
		ArrayList<Integer> list2 = (ArrayList<Integer>) Arrays.asList(2,3,4);
		ArrayList<Integer> list3 = (ArrayList<Integer>) Arrays.asList(6,7,8);
		ArrayList<ArrayList<Integer>> list = (ArrayList<ArrayList<Integer>>) Arrays.asList(list1,list2,list3);

		for (Integer integer : mergeKSortedArrays(list)) {
			System.out.println(integer);
		}
	}
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

		ArrayList<Integer> output = new ArrayList<>();
		PriorityQueue<triplet> pq = new PriorityQueue<>();

		//Storing first element of each array as triplet in priority queue
		for( int i = 0; i < input.size(); i++ ) {
			triplet tr = new triplet();
			tr.element = input.get(i).get(0);
			tr.arrayIndex = i;
			tr.elementIndex = 0;
			pq.add( tr );
		}
		while( !pq.isEmpty() ) {
			output.add(pq.peek().element);
			if( input.get(pq.peek().arrayIndex).size() > pq.peek().elementIndex + 1 ) {
				triplet tr = new triplet();
				tr.element = input.get(pq.peek().arrayIndex).get(pq.peek().elementIndex+1);
				tr.arrayIndex =  pq.peek().arrayIndex ;
				tr.elementIndex =  pq.peek().elementIndex + 1;
				pq.remove();
				pq.add( tr );
			}
			else {
				pq.remove();
			}
		}
		return output;		
	}
}