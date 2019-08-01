package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_273DeleteNodesGreaterOnRight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		reverseaList(head);
		deletenodes(head);
		reverseaList(head);
		display(head);
	}

	private static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	static Node head;
	static Node tail;
	static int size;

	public static void insert(int data) {

		Node nn = new Node(data, null);
		if (head == null) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}
		size++;
	}

	public static void display(Node n) {
		for (Node node = n; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	// ---------------------------------------------------------
	// This is a functional problem. Only these functions have to be written.
	public static void reverseaList(Node node) {
		Node prev = null;
		Node curr = node;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		head = prev;
		tail = node;

	}

	private static void deletenodes(Node head2) {
		int max = head2.data;
		Node node = head2.next;
		Node prev = head2;
		while (node != null) {
			if (node.data > max) {
				max = node.data;
				prev = node;
			} else {
				// the node needs to be deleted
				prev.next = node.next;
			}

			node = node.next;
		}
	}

	// --------------------------------------------------------

}

/*Test cases:
5
1 2 3 4 5
----------------
5

8
12 15 10 11 5 6  2 3
------------------------
15 11 6 3 

9
1 4 2 5 7 9 18 29 6
-----------------------
29 6

Source: https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/

*/