package LinkedList;

import java.util.Scanner;

public class Pep_JavaIP_9LinkedList_289Subtract2LinkedLists {

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

		subLinkedlists();
		//result banane ke baad ek baar reverse kiya h
		reverseaList(reshead);
		display(reshead);

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
	static Node reshead;
	static Node restail;

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
	// You have head1, head2 as the starting pointers of these 2 lists.
	// You have reshead as the pointer of resultant linked list which stores subtraction result of
	// these 2 lists.
	public static void subLinkedlists() {

		int size1 = 0;
		int size2 = 0;
		// find length of list2

		Node temp = head;
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
		if (size1 > size2) {
//			jitna 1st list bada h 2nd linked list h, utna 0's prepend kar denge 2nd list mai.
			for(int i=0; i<diff; i++) {
				Node nn=new Node(0,null);
				nn.next=head2;
				head2=nn;
			}
			
			//pehli list ko bhi reverse kar do 
			Node prev = null;
			Node curr = head;
			Node next = null;

			while (curr != null) {
				next = curr.next;
				curr.next = prev;

				prev = curr;
				curr = next;
			}
			tail = head;
			head= prev;
				
			//dusri list ko bhi reverse kar do
			Node prev2 = null;
			Node curr2 = head2;
			Node next2 = null;

			while (curr2 != null) {
				next2 = curr2.next;
				curr2.next = prev2;

				prev2 = curr2;
				curr2 = next2;
			}
			tail2= head2;
			head2= prev2;
			
			Node temp_itr1=head;
			Node temp_itr2=head2;
			Node resitr=reshead;
			int carry=0;
			while(temp_itr1!=null) {
				temp_itr1.data+=carry;
				if(temp_itr1.data<temp_itr2.data) {
					Node nn=new Node((temp_itr1.data+10)-temp_itr2.data,null);
					if(resitr==null) {
						resitr=nn;
						reshead=nn;
					}else {
					resitr.next=nn;
					resitr=nn;
					}
					carry=-1;
				}else {
					Node nn=new Node((temp_itr1.data-temp_itr2.data),null);
					if(resitr==null) {
						resitr=nn;
						reshead=nn;
					}else {
					resitr.next=nn;
					resitr=nn;
					}
					carry=0;
				}
				
				temp_itr1=temp_itr1.next;
				temp_itr2=temp_itr2.next;
			}
				
		} else {
			
			Node temp_itr1=head;
			Node temp_itr2=head2;
			Node resitr=reshead;
			int carry=0;
			while(temp_itr1!=null) {
				temp_itr1.data+=carry;
				if(temp_itr1.data<temp_itr2.data) {
					Node nn=new Node((temp_itr1.data+10)-temp_itr2.data,null);
					if(resitr==null) {
						resitr=nn;
						reshead=nn;
					}else {
					resitr.next=nn;
					resitr=nn;
					}
					carry=-1;
				}else {
					Node nn=new Node((temp_itr1.data-temp_itr2.data),null);
					if(resitr==null) {
						resitr=nn;
						reshead=nn;
					}else {
					resitr.next=nn;
					resitr=nn;
					}
					carry=0;
				}
				
				temp_itr1=temp_itr1.next;
				temp_itr2=temp_itr2.next;
			}
			
			
		}

	}

	public static void reverseaList(Node node) {

		// result waali list ko siddha karna padega
		Node prev = null;
		Node curr = node;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		reshead = prev;
		restail = node;

	}

	// -------------------------------------------------------

}

/*
Test cases:
4
4 6 1 2 
3 
3 2 0
---------------------------
4 2 9 2 
	
	
4
1 2 9 8
2
9 8
-----------------
1 2 0 0

15
1 1 1 1 1 1 1 1 1 1 1 2 3 4 5
10
1 1 1 9 9 2 3 4 5 1
-------------------------------
1 1 1 1 0 9 9 9 1 1 8 8 8 9 4
1 1 1 9 9 3 5 7 9 6 
	
	
	
	
	
Source: https://www.geeksforgeeks.org/subtract-two-numbers-represented-as-linked-lists/
	
	*/
