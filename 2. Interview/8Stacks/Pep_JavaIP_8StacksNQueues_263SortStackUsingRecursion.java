package Stacks;

import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class Pep_JavaIP_8StacksNQueues_263SortStackUsingRecursion {

	static void sortedInsert(Stack<Integer> s, int x) {
		// Base case: Either stack is empty or newly inserted
		// item is greater than top (more than all existing)
		if (s.isEmpty() || x > s.peek()) {
			s.push(x);
			return;
		}

		// If top is greater, remove the top item and recur
		int temp = s.pop();
		sortedInsert(s, x);

		// Put back the top item removed earlier
		s.push(temp);
	}

	// Method to sort stack
	static void sortStack(Stack<Integer> s) {
		// If stack is not empty
		if (!s.isEmpty()) {
			// Remove the top item
			int x = s.pop();

			// Sort remaining stack
			sortStack(s);

			// Push the top item back in sorted stack
			sortedInsert(s, x);
		}
	}

	// Utility Method to print contents of stack
	static void printStack(Stack<Integer> s) {
		ListIterator<Integer> lt = s.listIterator();

		// forwarding
		while (lt.hasNext())
			lt.next();

		// printing from top to bottom
		while (lt.hasPrevious())
			System.out.print(lt.previous() + " ");
	}

	// Driver method
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();
		for (int i = 0; i < size; i++) {
			s.push(scn.nextInt());
		}
		

		sortStack(s);

		printStack(s);

	}

}


/*Test Cases: 
5
-3 14 18 -5 30 
---------------
30 18 14 -3 -5 

10
1 -1 2 -2 3 -3 4 -4 5 -5
------------------
5 4 3 2 1 -1 -2 -3 -4 -5 

10
12 1 23 22 24 11 2 3 4 5
--------------------
24 23 22 12 11 5 4 3 2 1

Source: https://www.geeksforgeeks.org/sort-a-stack-using-recursion/

*/


