 						//MAX PRIORITY QUEUE

import java.util.ArrayList;

public class Max_Priority_Queue {

	private ArrayList<Integer> heap;

	public Max_Priority_Queue() {
		//initialy null arraylist
		heap = new ArrayList<>();
	}
	
	boolean isEmpty() {
		return heap.size() == 0;
	}
	//size of arraylist would be heap's size
	int size() {
		return heap.size();
	}

	/* Hence, Complexity of getting minimum value is: O(1) */
	int getMax() throws PriorityQueueException {
		if( isEmpty() ) {
			//Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	/*
	 * Complexity of adding a node is: O(1)
	 * 
	 * Complexity of swapping the nodes(upheapify): O(H) (swapping will be done H
	 * times in the worst case scenario)
	 * 
	 * Total complexity: O(1) + O(H) = O(H)
	 * 
	 * For a Complete Binary tree, its height H = O(log N), where N represents total
	 * no. of nodes.
	 * 
	 * Therefore, Overall Complexity of insert operation is O(log N).
	 */
	void insert( int element) {
		heap.add(element);
		//but now have to maintain heap order 
		//property by performing "Up-heapify"
		int childIndex = heap.size()-1;
		int parentIndex = ( childIndex -1 )/2;
		
		while( childIndex > 0 ) {
			if( heap.get(childIndex) > heap.get(parentIndex) ) {
				//swap
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp );
				//update childIndex and parentIndex
				//for further process
				childIndex = parentIndex;
				parentIndex = ( childIndex -1 )/2;
			}
			else {
				return;
			}
		}	
	}

	/*
	 * Complexity of swapping the nodes(downheapify): O(H) (swapping will be done H
	 * times in the worst case scenario)
	 * 
	 * Total complexity: O(1) + O(H) = O(H)
	 * 
	 * For a Complete Binary tree, its height H = O(log N), where N represents total
	 * no. of nodes.
	 * 
	 * Therefore, Overall Complexity of delete operation is O(log N).
	 */
	int removeMax() throws PriorityQueueException {
		
		if( isEmpty() ) {
			//Throw an exception
			throw new PriorityQueueException();
		}
		
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size()-1) );
		heap.remove(heap.size()-1);
		
		//but now have to maintain heap order 
		//property by performing down-heapify
		 
		//Initially
		int index = 0;
		int maxIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		
		//if leftchild hi nhi h thn no chance  
		//ki right ho so that is leaf node
		while( leftChildIndex < heap.size()) {
			if( heap.get(leftChildIndex) > heap.get(maxIndex)) {
				maxIndex = leftChildIndex;
			}
			if( rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(maxIndex)) {
				maxIndex = rightChildIndex;
			}
			if( maxIndex == index ) {
				break;
			}
			else {
				//swap
				int temp1 = heap.get(index);
				heap.set(index, heap.get(maxIndex));
				heap.set(maxIndex, temp1);
				//update
				index = maxIndex;
				leftChildIndex = (2*index + 1);
				rightChildIndex =  (2*index + 2);
			}
		}
		return temp;
	}	
}