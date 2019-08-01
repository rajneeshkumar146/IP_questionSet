package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_285ZigZagFashion {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}

		zigzagfashion();
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

	// -----------------------------------------
	// Functional Problem. You need to write this function only.

	private static void zigzagfashion() {
		Node curr = head.next;
		Node prev = head;
		boolean flag = true;
		while (curr != null) {
			if (flag) {
				// curr shd be greater than prev
				if (curr.data < prev.data) {
					int temp = curr.data;
					curr.data = prev.data;
					prev.data = temp;
				}
				flag = !flag;
			} else {
				// prev shd be greater than curr
				if (curr.data > prev.data) {
					int temp = curr.data;
					curr.data = prev.data;
					prev.data = temp;
				}
				flag = !flag;
			}
			prev = curr;
			curr = curr.next;
		}

	}

	// ----------------------------------------------------------------
}


/*
Test cases:
	5
	1 2 4 3 5
	-----------------
	1 4 2 5 3 
	
	9
	18 5 11 30 19 23 15 6 2
	--------------------------
	5 18 11 30 19 23 6 15 2  
	
	10
	14 -1 -9  5 6 29 84 29 40 23
	--------------------------------------------------------
	-1 14 -9 6 5 84 29 40 23 29 
	
	Source: https://www.geeksforgeeks.org/linked-list-in-zig-zag-fashion/
*/

