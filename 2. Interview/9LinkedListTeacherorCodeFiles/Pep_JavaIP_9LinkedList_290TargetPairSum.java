package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_290TargetPairSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a1 = sc.nextInt();
		insert(a1);

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			insert(a);
		}
		int target=sc.nextInt();
		Node head2=getmidnode();
		head2=reverselist(head2);
		pairtargetsum(head2,target);

	}

//--------------------------------------------
	//Functional Problem. Only these functions have to be written.
	private static Node reverselist(Node head2) {
		Node prev=null;
		Node curr=head2;
		Node next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			
			prev=curr;
			curr=next;
			
		}
		
		head2=prev;
		return head2;
	}


	private static void pairtargetsum(Node head2, int target) {
		Node temp=head;
		while(head2!=null && temp!=null) {
			if(head2.data+temp.data<target) {
				temp=temp.next;
			}else if(head2.data+temp.data>target) {
				head2=head2.next;
			}else {
				System.out.println(temp.data+" "+head2.data);
				temp=temp.next;
				head2=head2.next;
			}
		}
	}


	private static Node getmidnode() {
		Node fast=head;
		Node slow=head;
		while(fast!=null) {
			fast=fast.next;
			if(fast!=null) {
				fast=fast.next;
				slow=slow.next;
			}
		}
		
		Node head2=slow.next;
		slow.next=null;
		return head2;
	}

//------------------------------------------------------------------------------
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

}


/*
Test cases:
7
3 6 7 8 9 10 11
17
------------------------
6 11
7 10
8 9
	
	
6
1 2 7 9 8 10 
17
-------------------------
7 10
9 8	
	
Source: https://www.geeksforgeeks.org/find-pair-given-sum-sorted-singly-linked-without-extra-space/
	
	*/


