package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_292SortInPlaceIterative {

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

	// --------------------------------
	// Functional Problem. You just have to write this function to solve the
	// question
	public static void sortinplace() {
		Node prev = null;
		Node curr1 = head;
		Node next1 = head.next;
		Node curr2 = head2;
		Node next2 = head2.next;

		while (next1 != null && next2 != null) {
			
		}
	}

}
