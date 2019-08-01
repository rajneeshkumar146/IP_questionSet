--------------------------------------------------------------------------------
Description
--------------------------------------------------------------------------------
1. You have to implement a stack which will support following operations in O(1) time complexity:
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) middle() which will return middle element of the stack.
4) removeMiddle() which will delete the middle element.
Note -> Please read skeleton code carefully to implement these functions.
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
package Stacks;

import java.util.Scanner;

public class Pep_JavaIP_8StacksNQueues_246StackWithMiddleOps {

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
				System.out.println(st.middle());
				break;
			case 4:
				System.out.println(st.removeMiddle());
				break;
			case 5:
				st.display();
				break;
			default:
				return;
			}
		} while (true);

	}

	static class Stack {
		private class Node {
			int data;
			Node prev;
			Node next;
		}

		Node top;
		Node middle;
		int size;

		public Stack() {
			this.size = 0;
		}

		// These functions have to been written to solve this problem.
		// --------------------------------------------
		public void push(int item) {

		}

		public int pop() {

		}

		public int middle() {


		}

		public int removeMiddle() {


		}

		public void display() {
			Node temp = this.top;

			while (temp != null) {
				System.out.print(temp.data + ", ");
				temp = temp.prev;
			}
			System.out.println(".");
		}
		// -------------------------------------------------------
	}

}

/*Test Cases:
1 2
1 4
1 6
1 8
5
3
4
4
6
---------------
8, 6, 4, 2, .
4
4
6


1 2
1 4
1 6
1 8
1 10
2
2
2
5
3
4
4
6
------------------
10
8
6
4, 2, .
2
2
4


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
5
3
4
4
6
--------------------
16, 14, 12, 10, 8, 6, 8, 6, 4, 2, .
6
6
8


Source: https://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/

*/
