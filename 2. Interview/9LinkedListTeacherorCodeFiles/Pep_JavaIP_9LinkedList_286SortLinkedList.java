package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_286SortLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		sort();
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
	// ---------------------------------------------
	// Functional Problem. You have to write this function to solve the problem.

	public static void sort() {
		Node currhead = head;
		Node curr = head;
		Node prev = head;
		while (curr != null) {
			if (curr.data < 0) {
				// put it before head
				if (prev == head && curr == head) {
					curr = curr.next;
					continue;
				} else {
					prev.next = curr.next;
					curr.next = currhead;
					currhead = curr;
					curr = prev.next;
				}
			} else {
				// do nothing
				prev = curr;
				curr = curr.next;
			}
		}
		head = currhead;
	}
	// ------------------------------------
}

/*
Test cases:
	5
	1 -10 11 -12 20
	---------------
	-12 -10 1 11 20
	
	
	10
	1 2 3  4 5 -44 -55 66 77 88
	----------------------------
	-55 -44 1 2 3 4 5 66 77 88 
	
	
	11
	1 2 3  4 5 -44 -55 66 77 88 99
	---------------------------
	-55 -44 1 2 3 4 5 66 77 88 99 

Source: https://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/
*/