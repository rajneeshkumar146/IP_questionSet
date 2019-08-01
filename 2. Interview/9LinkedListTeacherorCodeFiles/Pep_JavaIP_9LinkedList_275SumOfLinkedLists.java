package LinkedList;

import java.util.Scanner;


public class Pep_JavaIP_9LinkedList_275SumOfLinkedLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		int n1 = sc.nextInt();
		int a2 = sc.nextInt();
		insert2(a2);

		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			insert2(a);
		}

		sumofLinkedlists(head, head2);
		reverseaList(reshead);
		display(reshead);

	}

	private static void insert2(int data) {
		Node nn = new Node(data, null);
		if (head2 == null) {
			head2 = nn;
			tail2 = nn;
		} else {
			tail2.next = nn;
			tail2 = nn;
		}
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
	static Node head2;
	static Node tail2;
	static Node reshead;
	static Node restail;

	public static void insert(int data) {

		Node nn = new Node(data, null);
		if (head == null) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}
	}

	public static void display(Node n) {
		for (Node node = n; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	// ---------------------------------------------------------
	// This is a functional problem. Only these function have to be written.
	// You have head1, head2 as the starting pointers of these 2 lists.
	// You have reshead as the pointer of resultant linked list which stores sum of these 2 lists.
	public static void sumofLinkedlists(Node head1, Node head2) {

		int size1 = 0;
		int size2 = 0;
		// find length of list2

		Node temp = head1;
		while (temp != null) {
			size1++;
			temp = temp.next;
		}
		// find length of list2

		temp = head2;
		while (temp != null) {
			size2++;
			temp = temp.next;
		}

		int diff = size1 - size2;
		if (size1 > size2) {
			temp = head1;
			for (int i = 0; i < diff; i++) {
				temp = temp.next;
			}
			int carry = findsumfromendtohere(temp, head2);
			findsumfromheretostart(head1, temp, carry);
		} else if (size2 > size1) {
			temp = head2;
			for (int i = 0; i < size2-size1; i++) {
				temp = temp.next;
			}
			int carry = findsumfromendtohere(head1, temp);
			findsumfromheretostart(head2, temp, carry);
		} else {
			int carry = findsumfromendtohere(head1, head2);
			if (carry != 0) {
				Node newnode = new Node(carry, null);
				restail.next = newnode;
				restail = newnode;
			}
		}

	}


	private static int findsumfromheretostart(Node head1, Node temp, int carry) {
		if (head1 == temp) {
			return carry;
		}

		int sum = findsumfromheretostart(head1.next, temp, carry);
		sum += head1.data;
		Node newnode = new Node(sum % 10, null);
		carry = sum / 10;
		if (reshead == null) {
			reshead = newnode;
			restail = newnode;
		} else {
			restail.next = newnode;
			restail = newnode;
		}
		return carry;
	}

	private static int findsumfromendtohere(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return 0;
		}
		int sum = findsumfromendtohere(node1.next, node2.next);
		sum += node1.data + node2.data;
		Node newnode = new Node(sum % 10, null);
		int carry = sum / 10;
		if (reshead == null) {
			reshead = newnode;
			restail = newnode;
		} else {
			restail.next = newnode;
			restail = newnode;
		}
		return carry;
	}
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

		reshead = prev;
		restail = node;

	}
	
	//-------------------------------------------------------

}

/*
Test cases:
	3
	5 4 3
	3
	8 4 3
	------------------------------
	1 3 8 6
	
	
	4
1 2 9 8
2
9 8
-----------------
1 3 9 6

 5
1 2 3 4 5
10
1 1 1 9 9 2 3 4 5 1
-------------------------------
1 1 1 9 9 3 5 7 9 6 
	
	
	
	
	
Source: https://www.geeksforgeeks.org/sum-of-two-linked-lists/
	
	*/


