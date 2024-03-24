
public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> Node1 = new Node<Integer>(30);
		Node<Integer> Node2 = new Node<Integer>(20);
		Node<Integer> Node3 = new Node<Integer>(10); // Making three nodes with data
		Node1.next = Node2;
		Node2.next = Node3; 
		Node<Integer> head = Node1;
		
		bubbleSort(head);
		print(head);

	}

	public static Node<Integer> bubbleSort(Node<Integer> head ) {
		if( head == null || head.next == null ){
			return head;
		}

		int length = length( head );

		for( int pos = 0; pos <= length-1; pos++){

			Node<Integer> prev = null; 
			Node<Integer> curr = head; 
			Node<Integer> nxt = curr.next;

			while( nxt != null ){               
				if( curr.data > nxt.data ){
					if( prev != null){ 
						prev.next = nxt;
						curr.next = nxt.next;
						nxt.next = curr;
						prev = prev.next;
						nxt = curr.next;

					}
					else{ 
						curr.next = nxt.next;
						nxt.next = curr;
						prev = nxt;
						nxt = curr.next;
						head = prev;                      
					}
				}
				else{
					prev = curr;
					curr = curr.next;
					nxt = nxt.next;                                    
				}           
			}  
		}
		return head;
	}

	public static int length(Node<Integer> head){

		int length = 0;
		while( head != null ){
			length ++;
			head = head.next;
		}
		return length;
	}

	public static void print(Node<Integer> head) {
		while (head != null) {
			System.out.println(head.data); // printing data of nodes
			head = head.next; // moving head ahead
		}
	}
}
