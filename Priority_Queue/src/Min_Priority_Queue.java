 				//MIN PRIORITY QUEUE

import java.util.ArrayList;

public class Min_Priority_Queue {

	private ArrayList<Integer> heap;

	public Min_Priority_Queue() {
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
	
	int getMin() throws PriorityQueueException {
		if( isEmpty() ) {
			//Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	void insert( int element) {
		heap.add(element);
		//but now have to maintain heap order 
		//property by performing "Up-heapify"
		int childIndex = heap.size()-1;
		int parentIndex = ( childIndex -1 )/2;
		
		while( childIndex > 0 ) {
			if( heap.get(childIndex) < heap.get(parentIndex) ) {
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
	int removeMin() throws PriorityQueueException {
		
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
		int minIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		
		//if leftchild hi nhi h thn no chance  
		//ki right ho so that is leaf node
		while( leftChildIndex < heap.size()) {
			
			if( heap.get(leftChildIndex) < heap.get(minIndex)) {
				minIndex = leftChildIndex;
			}
			if( rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
				minIndex = rightChildIndex;
			}
			if( minIndex == index ) {
				//means element is at right place
				break;
			}
			else {
				//swap
				int temp1 = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp1);
				//update
				index = minIndex;
				leftChildIndex = 2*index + 1;
				rightChildIndex = 2*index + 2;
			}	
		}
		return temp;
	}
}