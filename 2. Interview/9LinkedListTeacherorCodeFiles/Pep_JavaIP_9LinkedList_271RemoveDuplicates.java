package LinkedList;

import java.util.HashMap;
import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_271RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		
		removeDuplicates(head);
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

	public static void display() {
		for (Node node = head; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	public static void removeDuplicates(Node head) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		map.put(head.data, true);
		for (Node node = head.next; node != null; node = node.next) {
			map.put(node.data, true);
		}
		Node prev = head;
		for (Node node = head; node != null; node = node.next) {
			if (map.containsKey(node.data) && map.get(node.data) == false) {
				// this means it has been repeated and it has to be deleted
				prev.next = node.next;// This line deletes reference to the next node
				
			} else if (map.containsKey(node.data) && map.get(node.data) == true) {
				map.put(node.data, false);
				prev = node;
			}
			
		}

	}
	// -----------------------------------------------------

}

/*
Test cases:
	9
	1 2 3 4 5 3 3 4 4
	---------------
	1 2 3 4 5
	
	12
	18 5 11 30 5 19 19 23 15 6 6 2
	--------------------------
	18 5 11 30 19 23 15 6 2 
	
	36
	18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2 18 5 11 30 5 19 19 23 15 6 6 2
	--------------------------------------------------------
	18 5 11 30 19 23 15 6 2
	
	Source: https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
*/

