
class DoubleNodeClass {

	Node<Integer> head;
	Node<Integer> tail;
}

public class LinkedListUse {

	public static void main(String[] args) {

//		Node<Integer> Node1 = new Node<Integer>(10);
//		System.out.println( Node1.data );
//		System.out.println( Node1.next );
//		
//		Node<Integer> Node2 = new Node<Integer>(20);
//		System.out.println( Node2.data );
//		System.out.println( Node2.next );
//		
//		Node1.next = Node2;
//		
//		System.out.println( Node2 );
//		System.out.println( Node1.next );

		Node<Integer> Node1 = new Node<Integer>(10);
		Node<Integer> Node2 = new Node<Integer>(20);
		Node<Integer> Node3 = new Node<Integer>(30); // Making three nodes with data
		Node1.next = Node2;
		Node2.next = Node3; // Linking all nodes, last node is pointing to null

		Node<Integer> head = Node1; // as first node is head which will be pointed by both node1 and head
		print(head);
		print(head);
//		while( head != null ) {
//			System.out.println( head.data );
//			head = head.next;
//		}

	}

//==========================================================================================================	
	public static void print(Node<Integer> head) {
		while (head != null) {
			System.out.println(head.data); // printing data of nodes
			head = head.next; // moving head ahead
		}
	}

//========================================================================================================
	public static int length(Node<Integer> head) {

		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;

	}

//=========================================================================================================
	// ************************ith index element
	public static void printIth(Node<Integer> head, int i) { // time compkexity-->O(n)

		int count = 0;
		while (count < i && head != null) {
			count++;
			head = head.next;
		}
		if (head == null) {
			System.out.println();
		} else {
			System.out.println(head.data);
		}
	}

//==========================================================================================================
	// ******************************
	public static Node<Integer> insert(Node<Integer> head, int pos, int data) {

		Node<Integer> newNode = new Node<>(data);
		if (pos == 0) { // handling zero case
			newNode.next = head;
			head = newNode;
			return head; // adding return statement as there would be problem in case of pos being 0 as
							// head will change
		}
		int i = 0;
		Node<Integer> temp = head;
		while (i < pos - 1) { // traversing to the position-1 as there you need to insert element
			i++;
			temp = temp.next;
		}
		// Node<Integer> temp2 = temp.next;
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}

//============================================================================================================
	// Given a linked list and an integer n you need to find and return index
	// where n is present in the LL. Do this iteratively.
	public static int indexOfNIter(Node<Integer> head, int n) {

		Node<Integer> temp = head;
		int pos = 0;

		while (temp != null && temp.data != n) {
			pos++;
			temp = temp.next;
		}
		if (temp == null) {
			return -1;
		} else {
			return pos;
		}
	}

//==========================================================================================================
	// **************************************************
	// Given a linked list and an integer n, append the last n elements of the LL to
	// front.
	// 1 2 3 4 5 
	// 3
	// output->3 4 5 1 2
	public static Node<Integer> append(Node<Integer> root, int n) {

		Node<Integer> temp = root;
		if (n == 0) { // if n is 0 just return original linked list
			return root;
		}

		int num = 0;
		while (temp != null) { // Now iterate through the LL and get the total num of elements
			if (temp.next == null) { // and give adrs of first node to last node which will make an circular LL
				temp.next = root;
				num++;
				break;
			}
			num++;
			temp = temp.next;
		}

		temp = root;
		int pos = num - n; // getting position to append
		num = 0;
		while (num < pos - 1) {
			num++;
			temp = temp.next;
		}

		root = temp.next; // makeing new head
		temp.next = null; // making new last element

		return root;
	}
//===================================================================================================================
//******************************************************
	// Print a given linked list in reverse order. You need to print the tail first
	// and head last.
//    You can’t change any pointer in the linked list, just print it in reverse order.

	public class Solution {
		public void printReverseRecursive(Node<Integer> root) {

			if (root.next == null) { // Time complexity-->O(n)
				System.out.print(root.getData() + " ");
				return;
			}

			printReverseRecursive(root.next);
			System.out.print(root.getData() + " ");

		}
	}

//====================================================================================================================         
	// *************************************
//    Given a sorted linked list (elements are sorted in ascending order).
//    Eliminate duplicates from the given LL, such that output LL contains only unique elements.
//    1 2 3 3 3 4 4 5 5 5 7 -1
//    1 2 3 4 5 7
	public Node<Integer> removeDuplicates(Node<Integer> head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> i = head; // point to first node of LL
		Node<Integer> j = head.next; // point to second node of LL

		while (j != null) {

			if (!i.getData().equals(j.getData())) {

				i.next = j; // connecting two non-equal nodes
				i = i.next; // moving i and j forward
				j = j.next;
			}
			if (i.getData().equals(j.getData())) {
				j = j.next;
			}
		}
		i.next = j;
		return head;
	}

	// =====================================================================================================
//**************************
	// Given a linked list, find and return the midpoint.
//       If the length of linked list is even, return the first mid point.
	public static int printMiddel(Node<Integer> head) {

		if (head.next == null) {
			return head.getData();
		}

		Node<Integer> slow = head;
		Node<Integer> fast = head;

		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}
		return slow.getData();
	}

	// =========================================================================================
	// **************************************
	// Reverse a LL recursively

	public static Node<Integer> reverse_R(Node<Integer> head) { // time complexity O(n^2)

		if (head.next == null || head == null) {
			return head;
		}

		Node<Integer> finalHead = reverse_R(head.next);
		Node<Integer> temp = finalHead;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;
		head.next = null;

		return finalHead;

	}
	// ==========================================================================================
	// ****************************
	// Reverse a LL recursively double node

	public static DoubleNodeClass reverseDouble(Node<Integer> head) {

		if (head == null || head.next == null) { // time complexity--->O(n)

			DoubleNodeClass ans = new DoubleNodeClass(); // defined in starting
			ans.head = head; // this is how we can return two values from a function
			ans.tail = head;
			return ans;
		}

		DoubleNodeClass smallAns = reverseDouble(head.next);
		smallAns.tail.next = head;
		head.next = null;

		DoubleNodeClass ans = new DoubleNodeClass();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}

	// ========================================================================================
	// ======================================================
	// Reverse a LL with tail without double node

	public static Node<Integer> reverse_T(Node<Integer> head) { // time complexity O(n^2)

		if (head.next == null || head == null) {
			return head;
		}

		Node<Integer> revTail = head.next;
		Node<Integer> finalHead = reverse_T(head.next);

		revTail.next = head;
		head.next = null;

		return finalHead;

	}
//========================================================================================== 	
//******************************************************
	// Reverse a LL Iteratively

	public static Node<Integer> reverse_It(Node<Integer> head) {

		Node<Integer> prev = null;
		Node<Integer> curr = head;
		Node<Integer> temp;

		while (curr != null) {

			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head = prev;
		return head;
	}

	// =====================================================================================
	// Nth node from end of linked list
	int getNthFromLast(Node<Integer> head, int n) {
		Node<Integer> temp = head;
		int length = 0;

		while (temp != null) {
			temp = temp.next;
			length++;
		}
		if (length < n) {
			return -1;
		}
		int k = length - n + 1;

		temp = head;
		int i = 1;
		while (i < k) {

			temp = temp.next;
			i++;

		}
		return temp.data;
	}
//============================================================================================= 
	// Delete Nth node from the end of the given linked list, Without calculating
	// length of LL.

	/*
	 * Lets K be the total nodes in the linked list.
	 * 
	 * Observation : The Nth node from the end is (K-N+1)th node from the beginning.
	 * 
	 * So the problem simplifies down to that we have to find (K-N+1)th node from the
	 * beginning.
	 * 
	 * To do it in one pass. Let’s take the first pointer and move N step from the
	 * beginning. Now the first pointer is (K-N) steps away from the last node,
	 * which is the same number of steps the second pointer require to move from the
	 * beginning to reach the Nth node from the end.
	 */

	// Function to delete the nth node from
	// the end of the given linked list
	void deleteNode(Node<Integer> head, int key) {
		// First pointer will point to
		// the head of the linked list
		Node<Integer> first = head;
		// Second pointer will point to the
		// Nth node from the beginning
		Node<Integer> second = head;
		for (int i = 0; i < key; i++) {

			// If count of nodes in the given
			// linked list is <= N
			if (second.next == null) {
				// If count = N i.e. delete the head node
				if (i == key - 1)
					head = head.next;
				return;
			}
			second = second.next;
		}
		// Increment both the pointers by one until
		// second pointer reaches the end
		while (second.next != null) {
			first = first.next;
			second = second.next;
		}
		// First must be pointing to the
		// Nth node from the end by now
		// So, delete the node first is pointing to
		first.next = first.next.next;
	}



//===========================================================================================================
//Detect loop in a linked list
//Given a linked list, check if the linked list has loop or not. 
//Below diagram shows a linked list with a loop.

	public static boolean detectLoop(Node<Integer> head) { // timme complexity--->O(n)

		Node<Integer> slow = head;
		Node<Integer> fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

//============================================================================================================ 
// Detect and Remove Loop in a Linked List

	int detectAndRemoveLoop(Node<Integer> head) // Function that detects loop in the list
	{
		Node<Integer> slow = head, fast = head;
		while (slow != null && fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) { // If slow and fast meet at same point then loop is present
				removeLoop(slow, head);
				return 1;
			}
		}
		return 0;
	}

	void removeLoop(Node<Integer> loop, Node<Integer> head) // Function to remove loop
	{
		Node<Integer> ptr1 = loop;
		Node<Integer> ptr2 = loop;

		int k = 1, i; // Count the number of nodes in loop
		while (ptr1.next != ptr2) {
			ptr1 = ptr1.next;
			k++;
		}

		ptr1 = head; // Fix one pointer to head
		ptr2 = head;
		for (i = 0; i < k; i++) { // And the other pointer to k nodes after head
			ptr2 = ptr2.next;
		}

		while (ptr2 != ptr1) { // Move both pointers at the same pace, they will meet at loop starting node
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		while (ptr2.next != ptr1) { // Get pointer to the last node
			ptr2 = ptr2.next;
		}

		ptr2.next = null; // Set the next node of the loop ending node to fix the loop
	}
//=======================================================================================

}