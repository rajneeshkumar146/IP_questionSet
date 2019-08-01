package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_291Multiply {

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
		System.out.println(multiply());
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

	// ---------------------------------------------------------
	// This is a functional problem. Only these function have to be written.
	// You have head, head2 as the starting pointers of these 2 lists. Both of them
	// are static.
	public static int multiply() {
			Node temp1=head;
			Node temp2=head2;
			int num1=0;
			while(temp1!=null) {
				num1=num1*10+temp1.data;
				temp1=temp1.next;
			}
			
			int num2=0;
			while(temp2!=null) {
				num2=num2*10+temp2.data;
				temp2=temp2.next;
			}
			
			return num1*num2;
			
		}
	// -------------------------------------------------------

}

/*
Test cases:
	2
	1 2
	1
	3
	----------------
	36
	
	
	4
1 2 9 8
2
9 8
-----------------
127204

 5
1 2 3 4 5
3
1 1 1  
-------------------------------
1370295
	
	
	
	
	
Source:https://www.geeksforgeeks.org/multiply-two-numbers-represented-linked-lists/
	
	*/

