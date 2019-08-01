package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_296SortBiotonicDoublyLinkedList {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		
		Node result=findcriticalnode();
		display(result);

	}

	private static class Node {
		int data;
		Node next;
		Node back;

		public Node(int data, Node next, Node back) {
			this.data = data;
			this.next = next;
			this.back = back;
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
			nn.back = tail;
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

	public static void display(Node n) {
		for (Node node = n; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	// -------------------------------------
	// Functional Problem. You have to write this function to solve this question.
	public static Node findcriticalnode() {
		Node curr = head.next;
		boolean flag = false;
		while (curr != null) {
			if (curr.data < curr.back.data) {
				flag = true;
				break;
			}
			curr=curr.next;

		}
		// curr.back node starts a new list
		if (flag == true) {
			Node secondlist = curr.back;
			if(curr.back.back==null) {
				//it is already sorted in decreasing order
				//reverse it once and you will get your answer
				Node prev = null;
				Node next = null;
				while (secondlist != null) {
					next = secondlist.next;
					secondlist.next = prev;
					prev = secondlist;
					secondlist = next;
				}
				secondlist = prev;
				return secondlist;
			}
			curr.back.back.next = null;
			curr.back.back = null;
			Node prev = null;
			Node next = null;
			while (secondlist != null) {
				next = secondlist.next;
				secondlist.next = prev;

				prev = secondlist;
				secondlist = next;
			}

			secondlist = prev;
			Node firstlist = head;
			Node smallest = mergeLists(firstlist, secondlist);
			return smallest;
		}else {
			return head;
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
			n.next = mergeLists(first.next, second);

		} else {

			n = second;
			n.next = mergeLists(first, second.next);

		}

		return n;

	}

	// -------------------------------------

}
/*
Test cases:
	
8
2 5 7 12 10 6 4 1
--------------------
1 2 4 5 6 7 10 12 

8
1 2 3 4 5 6 7 8
----------------
1 2 3 4 5 6 7 8

8
8 7 6 5 4 3 2 1
---------------------
1 2 3 4 5 6 7 8 

10
1 2 5 12 15 5 4 3 2 1
--------------------
1 1 2 2 3 4 5 5 12 15 

Source: https://www.geeksforgeeks.org/sort-biotonic-doubly-linked-list/*/