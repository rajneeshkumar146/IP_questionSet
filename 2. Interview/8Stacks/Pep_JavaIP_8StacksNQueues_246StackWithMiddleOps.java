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
			if (this.top == null) {
				this.top = new Node();
				this.top.data = item;
				this.size++;
				this.middle = top;
				return;
			}

			Node node = new Node();
			node.data = item;
			top.next = node;
			node.prev = this.top;
			top = top.next;
			++this.size;

			if (this.size % 2 == 1) {
				this.middle = this.middle.next;
			}

		}

		public int pop() {
			if (top == null) {
				return -1;
			}

			int rv = top.data;

			top = top.prev;
			this.size--;

			if (this.size % 2 == 0) {
				this.middle = this.middle.prev;
			}

			return rv;
		}

		public int middle() {

			if (middle == null) {
				return -1;
			}
			return this.middle.data;
		}

		public int removeMiddle() {

			if (middle == null) {
				return -1;
			}

			int rv = this.middle.data;
			Node prevNode = middle.prev;
			Node nextNode = middle.next;
			this.size--;
			if (this.size % 2 == 0) {
				this.middle = this.middle.prev;
			}else {
				this.middle = this.middle.next;
			}
			
			if (prevNode != null)
				prevNode.next = nextNode;
			nextNode.prev = prevNode;
			return rv;

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
