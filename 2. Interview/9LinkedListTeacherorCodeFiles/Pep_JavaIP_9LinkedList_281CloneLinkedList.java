package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_281CloneLinkedList {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);
		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		Node temp = head;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			Node curr = search_Node(head, a);
			temp.arbitrary = curr;
			temp = temp.next;
		}
		Node result = cloneLL();
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
		for (Node node = nn; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
		//Node result=search_Node(nn, 3);
		
	}

	// -------------------------------------------
	// Functional problem. You just have to write this function.
	//The node it returns is the head of clone linked list.
	public static Node cloneLL() {
		Node curr = head;
		while (curr != null) {
			Node nn = new Node(curr.data, null, null);
			Node temp = curr.next;
			curr.next = nn;
			nn.next = temp;
			curr = curr.next.next;
		}

		curr = head;
		while (curr != null) {
			curr.next.arbitrary = curr.arbitrary.next;
			curr = curr.next.next;
		}
		curr = head;
		Node clonehead = curr.next;
		Node temp = clonehead;
		while (temp.next != null) {
				temp.next = temp.next.next;
				temp=temp.next;
		}
		
		return clonehead;
	}
	// ----------------------------------------------

}


/*
Test cases:
	5
	1 2 3 4 5
	3 1 5 3 2
	------------
	1 2 3 4 5 
	
	
	12
	18 5 11 30 5 19 19 23 15 6 6 2
	18 5 30 30 5 19 18 5 15 6 6 2
	--------------------------
	18 5 11 30 5 19 19 23 15 6 6 2
	
	36
	18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2
	18 5 19 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2
	--------------------------------------------------------
	18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 
	
	
	
Source:
	https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
	
	
	*/