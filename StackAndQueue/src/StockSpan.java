/*Afzal has been working with an organization called 'Money Traders' for the past few years.
The organization is into the money trading business. His manager assigned him a task.
For a given array/list of stock's prices for N days, find the stock's span for each day.
The span of the stock's price today is defined as the maximum number of consecutive
days(starting from today and going backwards) for which the price of the stock was less than
today's price.
For example, if the price of a stock over a period of 7 days are [100, 80, 60, 70, 60, 75, 85],
then the stock spans will be [1, 1, 1, 2, 1, 4, 6].*/
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		int[] price = {60, 70, 80, 100, 90, 75, 80, 120};
		int[] output = stockSpan(price);
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
	}
	public static int[] stockSpan(int[] price) {
        //O(n) complexity
		Stack<Integer> s = new Stack<>();
		int[] ans = new int[price.length];

		ans[0] = 1; // span for first index will be 1 always
		s.push(0); // will push indexes in stack

		for (int i = 1; i < price.length; i++) {
			
			// Pop elements from stack while stack is not empty and top of stack is smaller than price[i]
			while (!s.isEmpty() && price[s.peek()] < price[i]) {
				s.pop();
			}
			// If stack becomes empty, then price[i] is greater than all elements on left of it, i.e.,
			// price[0], price[1], ..price[i-1]. Else price[i]  is greater than elements after top of stack
			if (!s.isEmpty()) {
				ans[i] = i - s.peek();
			} else {
				ans[i] = i + 1;
			}
			// Push this index to stack 
			s.push(i);
		}
		return ans;
	}
}