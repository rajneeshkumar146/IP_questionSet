--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You have to implement stack using priority queue.
2. Write push(), pop() and display() functions for this stack.
Note -> Please read skeleton code carefully to implement these functions.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_248StackUSingPriorityQueue {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Stack st = new Stack();

		do {
			int choice = scn.nextInt();
			switch (choice) {
			case 1:
				st.push(scn.nextInt());
				break;
			case 2:
				System.out.println(st.pop());
				break;
			case 3:
				st.display();
				break;
			default:
				return;
			}
		} while (true);
	}

	static class Stack {

    //code


		// These functions have to been written to solve this problem.
		// --------------------------------------------
		public void push(int item) {

		}

		public int pop() {

		}

		public void display() {

		}
		// -------------------------------------------------------
	}

}

/*Test Cases:
1 2
1 4
1 6
1 8
2
2
3
6
---------------
8
6
4 2


1 2
1 4
1 6
1 8
1 10
2
2
2
3
6
------------------
10
8
6
4 2


1 2
1 4
1 6
1 8
1 6
1 8
1 10
1 12
1 14
1 16
2
2
3
4
--------------------
16
14
12 10 8 6 8 6 4 2


Source: https://www.geeksforgeeks.org/implement-stack-using-priority-queue-or-heap/

*/
