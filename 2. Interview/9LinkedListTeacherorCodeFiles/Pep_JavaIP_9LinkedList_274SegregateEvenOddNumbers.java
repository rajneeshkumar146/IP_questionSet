package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_274SegregateEvenOddNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		make2lists(head);
		display(head);
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

	public static void display(Node n) {
		for (Node node = n; node != null; node = node.next) {
			System.out.print(node.data + " ");
		}
	}

	// ---------------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	
	public static void make2lists(Node node) {
		Node ohead=null;
		Node ehead=null;

		Node otail=null;
		Node etail=null;
		while(node!=null) {
			if(node.data%2==0 && ehead==null) {
				Node nn=new Node(node.data, null);
				ehead=nn;
				etail=nn;
			}else if(node.data%2==0 && ehead!=null) {
				Node nn=new Node(node.data, null);
				etail.next=nn;
				etail=nn;
			}else if(node.data%2!=0 && ohead==null) {
				Node nn=new Node(node.data, null);
				ohead=nn;
				otail=nn;
			}else if(node.data%2!=0 && ohead!=null) {
				Node nn=new Node(node.data, null);
				otail.next=nn;
				otail=nn;
			}
			node=node.next;
		}
		
		head=ehead;
		etail.next=ohead;
		tail=otail;
	}
	// --------------------------------------------------------

}

/*
Test cases:
	5
	1 5 3 2 4
	---------------
	2 4 1 5 3 
	
	9
	18 5 11 30 19 23 15 6 2
	--------------------------
	18 30 6 2 5 11 19 23 15   
	
	10
	14 -1 -9  5 6 29 84 29 40 23
	--------------------------------------------------------
	14 6 84 40 -1 -9 5 29 29 23  
	
	Source: https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
*/