import java.util.LinkedList;
import java.util.Queue;

public class stackUsingTwoQueue {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	/* The method pop which return the element poped out of the stack */
	int pop() {
		// Your code here
		if (!q1.isEmpty()) {
			return q1.remove();
		}
		return -1;
		
	}

	/* The method push to push element into the stack */
	void push(int a) {
		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}

		q1.add(a);

		while (!q2.isEmpty()) {
			q1.add(q2.remove());
		}
	}
}