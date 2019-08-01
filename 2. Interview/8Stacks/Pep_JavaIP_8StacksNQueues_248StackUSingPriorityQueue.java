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
		private class Node implements Comparable<Node> {
			int value;
			int count;

			public Node(int value, int count) {
				this.value = value;
				this.count = count;
			}

			@Override
			public int compareTo(Node o) {
				// TODO Auto-generated method stub
				return this.count - o.count;
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue(Collections.reverseOrder());
		int count;

		public Stack() {
			this.count = 0;
		}

		// These functions have to been written to solve this problem.
		// --------------------------------------------
		public void push(int item) {
			count++;
			Node node = new Node(item, count);
			pq.add(node);
		}

		public int pop() {
			if (pq.size() == 0) {
				return -1;
			}
			int rv = pq.remove().value;
			return rv;
		}

		public void display() {
			Node[] data = new Node[pq.size()];
			int k = 0;
			while (pq.isEmpty() == false) {
				Node rn = pq.remove();
				System.out.print(rn.value + " ");
				data[k++] = rn;
			}
			
			for(int i=0; i<data.length; i++) {
				pq.add(data[i]);
			}
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

