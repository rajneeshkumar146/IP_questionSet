package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_295TripletsinDoublyLinkedList {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		int target = sc.nextInt();
		TripletSum(target);

	}

	private static class Node {
		int data;
		Node next;
		Node back;

		public Node(int data, Node next, Node back) {
			this.data = data;
			this.next = next;
			this.back = back;
		}

	}

	static Node head;
	static Node tail;
	static int size;

	public static void insert(int data) {

		Node nn = new Node(data, null, null);
		if (head == null) {
			head = nn;
			tail = nn;
		} else {
			nn.back = tail;
			tail.next = nn;
			tail = nn;
		}
		size++;
	}

	public static Node search_Node(Node head, int k) {
		while (head != null) {
			if (head.data == k) {
				return head;
			}
			head = head.next;
		}
		return null;
	}

	public static void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	// ---------------------------------------------
	// Functional Problem. You only have to write this function to solve this
	// question.
	// All the nodes have distinct data stored in them.
	public static void TripletSum(int target) {
		Node curr = head;
		int count = 0;
		for (curr = head; curr.next != tail; curr = curr.next) {
			Node fp = curr.next;
			Node lp = tail;
			while (fp.data < lp.data) {
				if (curr.data + fp.data + lp.data == target) {
//					System.out.println(curr.data+" "+lp.data+" "+fp.data);
					count++;
					lp = lp.back;
					fp = fp.next;
				} else if (curr.data + fp.data + lp.data < target) {
					fp = fp.next;
				} else {
					lp = lp.back;
				}

			}
		}
		System.out.println(count);
	}

	// -----------------------------------------

}
/*
Test cases:
	
7
1 2 4 5 6 8 9
17
------------------
2

7
1 2 4 5 6 8 9
15
----------------
5

10
1 2 3 5 12 15 16 18 19 20
23
------------------------
5
Source: https://www.geeksforgeeks.org/count-triplets-sorted-doubly-linked-list-whose-sum-equal-given-value-x/
*/