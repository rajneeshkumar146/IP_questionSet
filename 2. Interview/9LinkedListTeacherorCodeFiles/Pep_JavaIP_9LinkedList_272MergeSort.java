package LinkedList;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_272MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}

		Node node=mergeSort(head);
		display(node);
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

	// -----------------------------------------------------
	// This is a functional problem. Only these functions have to be written.
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
			n.next = mergeLists(first.next, second);

		} else {

			n = second;
			n.next = mergeLists(first, second.next);

		}

		return n;

	}

	public static Node mergeSort(Node node) {

		if (node == null) {
			return null;
		}

		if (node.next == null) {
			return node;
		}

		Node mid = getMidNode(node);
		Node midNext = mid.next;

		mid.next = null;
		Node firstList = mergeSort(node);
		Node secondList = mergeSort(midNext);

		return mergeLists(firstList, secondList);

	}

	public static Node getMidNode(Node node) {

		Node slow = node, fast = node.next;

		while (fast != null) {

			fast = fast.next;

			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}

		}
		return slow;
	}

	// -----------------------------------------------------

}

/*
Test cases:
	5
	1 5 3 2 4
	---------------
	1 2 3 4 5
	
	9
	18 5 11 30 19 23 15 6 2
	--------------------------
	2 5 6 11 15 18 19 23 30  
	
	10
	14 -1 -9  5 6 29 84 29 40 23
	--------------------------------------------------------
	-9 -1 5 6 14 23 29 29 40 84 
	
	Source: https://www.geeksforgeeks.org/merge-sort-for-linked-list/
*/


