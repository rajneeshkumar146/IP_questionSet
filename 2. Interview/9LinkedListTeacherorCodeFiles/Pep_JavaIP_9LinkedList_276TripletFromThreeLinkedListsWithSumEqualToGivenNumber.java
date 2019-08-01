package LinkedList;

import java.util.Scanner;


public class Pep_JavaIP_9LinkedList_276TripletFromThreeLinkedListsWithSumEqualToGivenNumber {

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

		int n2 = sc.nextInt();
		int a3 = sc.nextInt();
		insert3(a3);

		for (int i = 1; i < n1; i++) {
			int a = sc.nextInt();
			insert3(a);
		}
		
		int target=sc.nextInt();
		
		printTripletSumFromThreeList(head, head2, head3, target);
		

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
	
	private static void insert3(int data) {
		Node nn = new Node(data, null);
		if (head3 == null) {
			head3 = nn;
			tail3 = nn;
		} else {
			tail3.next = nn;
			tail3 = nn;
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
	static Node head3;
	static Node tail3;

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

	//----------------------------------------------------------
	// This is a functional problem. Only these functions have to be written.
	public static boolean printTripletSumFromThreeList(Node one, Node two, Node three, int target) {

		two=mergeSort(two);
		
		three=mergeSort(three);
		three=reverseaList(three);

		Node temp2=two;
		Node temp3=three;
		while (one != null) {
			two=temp2;
			three=temp3;
			while (two != null && three != null) {

				int sum = one.data + two.data + three.data;
				if (sum == target) {
					System.out.println(one.data + ", " + two.data + ", " + three.data);
					return true;
				} else if (sum < target) {

					two = two.next;
				} else {
					three = three.next;

				}

			}

			one = one.next;
		}

		System.out.println("No such pair found");
		return false;
	}
	
	public static Node reverseaList(Node node) {
		Node prev = null;
		Node curr = node;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		Node myhead=prev;
		return myhead;

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
	//----------------------------------------------------------
}

/*Test cases:
3
12 6 29
3
23 5 8
3
90 20 59
101
------------------------
6, 5, 90

4
10 15 4 20
4
10 9 4 2
4
1 2 4 8
25
-------------------------
15, 2, 8

4
20 4 15 10
4
10 9 4 2
4
1 2 4 8
25
-------------------------
20, 4, 1

Source: https://www.geeksforgeeks.org/find-a-triplet-from-three-linked-lists-with-sum-equal-to-a-given-number/
*/