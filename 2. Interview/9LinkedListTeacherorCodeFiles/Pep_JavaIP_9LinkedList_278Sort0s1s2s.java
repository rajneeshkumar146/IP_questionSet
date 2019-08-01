package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_278Sort0s1s2s {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		make3lists(head);
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
	
	public static void make3lists(Node node) {
		Node zhead=null;
		Node ohead=null;
		Node thead=null;

		Node ztail=null;
		Node otail=null;
		Node ttail=null;
		while(node!=null) {
			if(node.data==0 && zhead==null) {
				Node nn=new Node(node.data, null);
				zhead=nn;
				ztail=nn;
			}else if(node.data==0 && zhead!=null) {
				Node nn=new Node(node.data, null);
				ztail.next=nn;
				ztail=nn;
			}else if(node.data==1 && ohead==null) {
				Node nn=new Node(node.data, null);
				ohead=nn;
				otail=nn;
			}else if(node.data==1 && ohead!=null) {
				Node nn=new Node(node.data, null);
				otail.next=nn;
				otail=nn;
			}else if(node.data==2 && thead==null) {
				Node nn=new Node(node.data, null);
				thead=nn;
				ttail=nn;
			}else if(node.data==2 && thead!=null) {
				Node nn=new Node(node.data, null);
				ttail.next=nn;
				ttail=nn;
			}
			node=node.next;
		}
		
		head=zhead;
		ztail.next=ohead;
		otail.next=thead;
		tail=ttail;
	}
	// --------------------------------------------------------


}

/*
Test cases:
	11
	1 2 0 0 0 1 1 1 2 2 2
	------------------------
	0 0 0 1 1 1 1 2 2 2 2
	
	16
	1 2 0 0 0 1 1 1 2 2 2 2 1 1 1 2 
	--------------------------
	0 0 0 1 1 1 1 1 1 1 2 2 2 2 2 2 
	
	20
	1 2 0 0 0 1 1 1 2 2 2 2 1 1 1 2 1 0 0 2
	--------------------------------------------------------
	0 0 0 0 0 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2  
	
	Source: https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
*/
