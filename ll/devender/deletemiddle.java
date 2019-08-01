package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class deletemiddle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node deletemiddle(Node head){
	
	
	if(head==null||head.next==null){//if list is empty or containing one element
		return null;
	}
	Node slow=head;//1
	Node fast=head;//2
	Node prev=null;
	while(fast!=null&&fast.next!=null){//traverse until middle
		fast=fast.next.next;
		prev=slow;
		slow=slow.next;
	}
	prev.next=slow.next;//delete middle
	return head;
}
}
