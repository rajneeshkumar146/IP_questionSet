package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_282PointToNextHigherValue {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		setArbitrary();
		Node result = mergeSort(head);
		display(result);
	}

	private static class Node {
		int data;
		Node next;
		Node arbitrary;

		public Node(int data, Node next, Node arbitrary) {
			this.data = data;
			this.next = next;
			this.arbitrary = arbitrary;
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

	public static void display(Node nn) {
		for (Node node = nn; node != null; node = node.arbitrary) {
			System.out.print(node.data + " ");
		}
		// Node result=search_Node(nn, 3);

	}

	// -------------------------------------------
	// Functional problem. You just have to write this function.
	// The display function is set on arbitrary pointer. Starting from pointer
	// returned by merge sort, it will go to the node, pointed by arbitrary node.
	// As the pointer returned by mergesort, always contains the node having smallest value and arbitrary pointer
	// takes us to the next higher value. So, it should display sorted output.
	public static void setArbitrary() {
		for (Node node = head; node != null; node = node.next) {
			node.arbitrary = node.next;
		}
	}

	public static Node mergeLists(Node first, Node second) {

		if (first == null) {
			return second;
		}

		if (second == null) {
			return first;
		}

		Node n = null;
		if (first.data < second.data) {

			n = first;
			n.arbitrary = mergeLists(first.arbitrary, second);

		} else {

			n = second;
			n.arbitrary = mergeLists(first, second.arbitrary);

		}

		return n;

	}

	public static Node mergeSort(Node node) {

		if (node == null) {
			return null;
		}

		if (node.arbitrary == null) {
			return node;
		}

		Node mid = getMidNode(node);
		Node midNext = mid.next;

		mid.arbitrary = null;
		Node firstList = mergeSort(node);
		Node secondList = mergeSort(midNext);

		return mergeLists(firstList, secondList);

	}

	public static Node getMidNode(Node node) {

		Node slow = node, fast = node.next;

		while (fast != null) {

			fast = fast.arbitrary;

			if (fast != null) {
				slow = slow.arbitrary;
				fast = fast.arbitrary;
			}

		}
		return slow;
	}
	// ----------------------------------------------

}

/*
Test cases:
	5
	3 1 5 4 2
	------------
	1 2 3 4 5 
	
	
	12
	18 5 11 30 5 19 19 23 15 6 6 2
	--------------------------
	2 5 5 6 6 11 15 18 19 19 23 30 
	
	36
	18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2
	--------------------------------------------------------
	2 2 2 5 5 5 5 5 5 6 6 6 6 6 6 11 11 11 15 15 15 18 18 18 19 19 19 19 19 19 23 23 23 30 30 30 
	
	
	
Source:
	https://www.geeksforgeeks.org/point-to-next-higher-value-node-in-a-linked-list-with-an-arbitrary-pointer/
	
	
	*/
