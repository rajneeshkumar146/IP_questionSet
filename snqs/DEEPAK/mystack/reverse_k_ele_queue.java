package mystack;
import java.util.*;
public class reverse_k_ele_queue {

	
	static void reverseQueueFirstKElements(Queue<Integer>queue, int k) { 
		if (queue.isEmpty() == true || k > queue.size()) 
			return; 
		if (k <= 0) 
			return; 

		Stack<Integer> stack = new Stack<Integer>(); 

		// Push the first K elements into a Stack 
		for (int i = 0; i < k; i++) { 
			stack.push(queue.peek()); 
			queue.remove(); 
		} 

		
		// Enqueue the contents of stack at the back 
		// of the queue 
		while (!stack.empty()) { 
			queue.add(stack.peek()); 
			stack.pop(); 
		} 

		
		// Remove the remaining elements and enqueue 
		// them at the end of the Queue 
		for (int i = 0; i < queue.size() - k; i++) { 
			queue.add(queue.peek()); 
			queue.remove(); 
		} 
                Print(queue);
	} 

	// Utility Function to print the Queue 
	static void Print(Queue<Integer>queue) { 
		while (!queue.isEmpty()) { 
			System.out.print(queue.peek() + " "); 
			queue.remove(); 
		} 
	} 

	public static void main(String[] args) {

		Queue<Integer> q=new LinkedList<Integer>(); 
		Scanner sc=new Scanner(System.in);
		int n=5;
		int k=3;
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		reverseQueueFirstKElements(q, k);
		
	}

}
