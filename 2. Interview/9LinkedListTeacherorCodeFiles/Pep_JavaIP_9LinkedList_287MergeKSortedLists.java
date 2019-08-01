package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_287MergeKSortedLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		head=insert(head, tail, a1);
		tail=head;

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			tail.next=insert(head, tail, a);
			tail=tail.next;
		}
		int n1 = sc.nextInt();
		int a2 = sc.nextInt();
		head1=insert(head1, tail1, a2);
		tail1=head1;
		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			tail1.next=insert(head1, tail1, a);
			tail1=tail1.next;
		}
		int n2 = sc.nextInt();
		int a3 = sc.nextInt();
		head2=insert(head2, tail2, a3);
		tail2=head2;
		for (int i = 1; i < n2; i++) {
			int a = sc.nextInt();
			tail2.next=insert(head2, tail2, a);
			tail2=tail2.next;
		}
		int n3 = sc.nextInt();
		int a4 = sc.nextInt();
		head3=insert(head3, tail3, a4);
		tail3=head3;
		for (int i = 1; i < n3; i++) {
			int a = sc.nextInt();
			tail3=insert(head3, tail3, a);
		}

		Node[] arr = new Node[4];
		arr[0] = head;
		arr[1] = head1;
		arr[2] = head2;
		arr[3] = head3;
		head=mergesort(arr);
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
	static Node head1;
	static Node tail1;
	static Node head2;
	static Node tail2;
	static Node head3;
	static Node tail3;

	public static Node insert(Node start, Node end, int data) {

		Node nn = new Node(data, null);
		if (start == null) {
			start = nn;
			end = nn;
		} else {
			end.next = nn;
			end = nn;
		}
		return nn;
	}

	public static void display(Node n) {
		for (Node node = n; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}
	// --------------------------------------------------------
	// Functional Problem. You just have to write this function.

	private static Node mergesort(Node[] arr) {
		int last = arr.length - 1;
		while (last != 0) {
			int i = 0, j = last;
			while (i < j) {
				arr[i] = SortedMerge(arr[i], arr[j]);
				i++;
				j--;
				if (i >= j)
					last = j;
			}
		}

		return arr[0];
	}

	private static Node SortedMerge(Node first, Node second) {

		if (first == null) {
			return second;
		}

		if (second == null) {
			return first;
		}

		Node n = null;
		if (first.data < second.data) {

			n = first;
			n.next = SortedMerge(first.next, second);

		} else {

			n = second;
			n.next = SortedMerge(first, second.next);

		}

		return n;
	}

	// --------------------------------------------------------

}

/*
Test cases:
	5
	1 2 3 4 5
	6
 	12 13 14 15 16 17
	2
	18 19
	3
	7 8 9
	--------------------------------
	1 2 3 4 5 7 8 9 12 13 14 15 16 17 18 19 
	

	6
 	12 13 14 15 16 17
	2
	18 19
	3
	7 8 9
	7
	5 6 11 12 18 19 30
	--------------------------
	5 6 7 8 9 11 12 12 13 14 15 16 17 18 18 19 19 30  
	
	
	
	Source: https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
*/

