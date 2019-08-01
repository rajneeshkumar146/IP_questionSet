package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_283RearrangeLinkedListInPlace {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}

		rearrange();
		display();

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

	// -----------------------------------------------
	// Functional Problem. Only this function is needed to be written.
	private static void rearrange() {
		Node fast = head;
		Node slow = head;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}

		Node mid = slow.next;
		slow.next = null;

		Node prev = null;
		Node curr = mid;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		// curr here points the last value. We now have to merge two lists.
		Node one = head;
		Node two = prev;

		while (one != null && two != null) {
			Node saveone = one.next;
			one.next = two;
			Node savetwo = two.next;
			two.next = saveone;
			one = saveone;
			two = savetwo;
		}

		if (one == null) {
			Node node = null;
			for (node = head; node.next != null; node = node.next) {

			}
			node.next = two;
		}
		if (two == null) {
			// do nothing
		}
	}

	// ----------------------------------------------------------------

}


/*
Test cases:
	7
	1 2 3 4 5 6 7
	---------------------
	1 7 2 6 3 5 4
	
	9
	18 5 11 30 19 23 15 6 2
	--------------------------
	18 2 5 6 11 15 30 23 19  
	
	10
	14 -1 -9  5 6 29 84 29 40 23
	--------------------------------------------------------
	14 23 -1 40 -9 29 5 84 6 29 
	
	Source: https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
*/



