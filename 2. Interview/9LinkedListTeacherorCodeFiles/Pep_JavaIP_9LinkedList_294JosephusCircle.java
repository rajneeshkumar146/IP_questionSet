package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_294JosephusCircle {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			insert(i);
		}

		circularlist(m);
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

	// -------------------------------------
	// Functional Problem. You have to write this function to solve this question
	public static void circularlist(int m) {
		tail.next = head;
		Node curr = head;
		Node prev=null;
		while (size != 1) {
			for (int i = 0; i < m - 1; i++) {
				prev=curr;
				curr = curr.next;
			}
			// remove curr
			curr.data = curr.next.data;
			curr.next = curr.next.next;
			size--;
		}
		System.out.println(prev.data);
	}
	//----------------------------------------
}
/*
Test Cases:
	5 2
	---------
	3
	
	5 3
	------------
	4
	
	16 2
	------------
	1
	
	Source: https://www.geeksforgeeks.org/josephus-circle-using-circular-linked-list/
	
	
*/