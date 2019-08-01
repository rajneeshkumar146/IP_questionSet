package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class rotatedoublylinkedlistbypnodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node vr(Node head,int n){
	Node cur=head;
	int count=1;
	while(cur!=null&&count<n){
		cur=cur.next;
		count++;
	}
	if(cur==null){
		return head;
	}

	Node kth=cur;
	while(cur.next!=null){
		cur=cur.next;
	}
	Node tail=cur;
	if(cur==null){
		return head;
	}
	Node next=kth.next;
	next.prev=null;
	kth.next=null;
	tail.next=head;
	head.prev=tail;
	head=next;
	
}
}
