package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_277FlattenALinkedList {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int a1 = scn.nextInt();
		Node downkahead = insertright(a1);
		int downskasize = scn.nextInt();

		Node downs = null;

		for (int i1 = 0; i1 < downskasize; i1++) {
			int a = scn.nextInt();
			if (i1 == 0)
				downs = insertdown(downkahead, a);
			else {
				downs = insertdown(downs, a);
			}
		}
		for (int i = 1; i < n; i++) {
			int rightvalue = scn.nextInt();
			downkahead = insertright(rightvalue);
			downskasize = scn.nextInt();

			downs = null;

			for (int i1 = 0; i1 < downskasize; i1++) {
				int a = scn.nextInt();
				if (i1 == 0)
					downs = insertdown(downkahead, a);
				else {
					downs = insertdown(downs, a);
				}
			}

		}
		flatten(head);
		display(head);
	}

	private static Node insertdown(Node downkahead, int a) {
		Node nn = new Node(a, null, null);
		downkahead.down = nn;
		return nn;
	}

	static Node head;
	static Node tail;
	static int size;

	private static class Node {
		int data;
		Node next;
		Node down;

		public Node(int data, Node next, Node down) {
			this.data = data;
			this.next = next;
			this.down = down;
		}
	}

	private static Node insertright(int data) {
		Node nn = new Node(data, null, null);
		if (head == null) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}

		return nn;
	}
	
	public static void display(Node n) {
		for (Node node = n; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}
	// ---------------------------------------------
	// This is a functional problem. You have to write just this function to solve
	// the problem.

	public static void flatten(Node node) {
		Node prev = null;
		Node curr = node;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			if (curr.down != null) {
				curr.next = curr.down;
				Node nodedown = curr.down;
				while (nodedown.down != null) {
					nodedown.next = nodedown.down;
					nodedown=nodedown.next;
				}
				nodedown.next=next;
			}
			curr=next;
		}
	}

	// ---------------------------------------------
}

/*Test cases:
5
1 3 7 8 9
2 0
3 0
4 2 5 6
5 0
---------------------
1 7 8 9 2 3 4 5 6 5 

4
5 3 7 8 30
10 1 20
19 2 22 50
28 3 35 40 45
-----------------------------------
5 7 8 30 10 20 19 22 50 28 35 40 45 

5
5 3 7 8 30
10 1 20
19 2 22 50
28 5 35 40 45 1 2
0 5 0 0 0 0 0
--------------------------------
5 7 8 30 10 20 19 22 50 28 35 40 45 1 2 0 0 0 0 0 0 

Source: https://www.geeksforgeeks.org/flattening-a-linked-list/
*/


