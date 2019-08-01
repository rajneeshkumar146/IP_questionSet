package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_266DeleteNodeWithoutHead {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int a1 = sc.nextInt();
			insert(a1);
			
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				insert(a);
			}

			int k = sc.nextInt();
			Node del = search_Node(head, k);

			
			if (del != null && del.next != null) {
				deleteNode(del);
			}
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
		while(head!=null) {
			if(head.data==k) {
				return head;
			}
			head=head.next;
		}
		return null;
	}

	public static void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data+" ");
		}
	}

	
//---------------------------------------------------------------
	//This is a functional problem. Only this function has to be written. 
	private static void deleteNode(Node del) {
		if (del.next == null) {
			del = null;
			return;
		}

		del.data = del.next.data;
		del.next = del.next.next;
	}
//------------------------------------------------------------------

	
}



/*
Test cases:
	5
	1 2 3 4 5
	3
	------------
	1 2 4 5
	
	
	12
	18 5 11 30 5 19 19 23 15 6 6 2
	11
	--------------------------
	18 5 30 5 19 19 23 15 6 6 2
	
	36
	18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2
	30
	--------------------------------------------------------
	18 5 11 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2  
	
	
	
Source:
	https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/*/