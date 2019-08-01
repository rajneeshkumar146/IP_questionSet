package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_268PrintNthNodeFromEnd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}

		int k = sc.nextInt();
		nthfromlast(head, k);

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

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	public static void nthfromlast(Node head, int n) {
		Node slow = head;
		Node fast = head;
		while (n-- > 0) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		System.out.println(slow.data);

	}
	// ---------------------------------------------------------

}

/*
Test cases:
	5
	1 2 3 4 5
	2
	---------------
	4
	
	12
	18 5 11 30 5 19 19 23 15 6 6 2
	11
	--------------------------
	5
	
	36
	18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2
	30
	--------------------------------------------------------
	19  
	
	Source: https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
*/