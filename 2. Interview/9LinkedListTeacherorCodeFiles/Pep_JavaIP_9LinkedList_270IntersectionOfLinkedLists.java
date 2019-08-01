package LinkedList;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_270IntersectionOfLinkedLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		HashMap<Integer, Node> map = new HashMap<>();
		map.put(a1, head);
		for (Node node = head.next; node != null; node = node.next) {
			map.put(node.data, node);
		}
		int n2 = sc.nextInt();
		int a2 = sc.nextInt();
		insert2(a2);
		Node prev=head2;
		for (int i = 1; i < n2; i++) {
			int a = sc.nextInt();
			if(map.containsKey(a)) {
				prev.next=map.get(a);
				break;
			}
			prev=insert2(a);
			
		}
		
		System.out.println(findIntersectionPoint(head, head2).data);
		

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

	public static Node insert2(int data) {

		Node nn = new Node(data, null);
		if (head2 == null) {
			head2 = nn;
			tail2 = nn;
		} else {
			tail2.next = nn;
			tail2 = nn;
		}
		size++;
		return nn;
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	public static Node findIntersectionPoint(Node head1, Node head2) {

		int size1 = 0;
		int size2 = 0;
		// find length f list2

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

		temp = head1;
		for (int i = 0; i < diff; i++) {
			temp = temp.next;
		}

		Node temp2 = head2;

		while (temp != null && temp2 != null) {

			if (temp == temp2) {
				return temp;
			}

			temp = temp.next;
			temp2 = temp2.next;
		}

		return null;
	}
	
	
	// -----------------------------------------------------

}

/*
Test cases:
	5
	1 2 3 4 5
	3
	12 4 5
	---------------
	4
	
	12
	18 5 11 30 5 19 19 23 15 6 6 2
	5
	46 12 6 6 2
	--------------------------
	6
	
	36
	18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2
	3
	12 6 2
	--------------------------------------------------------
	6 
	
	Source: https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
*/
