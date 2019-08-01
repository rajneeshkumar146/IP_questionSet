package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class removecycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node remove(Node head){
	Node slow=head.next;
	Node fast=head.next.next;
	while(fast!=null&&fast.next!=null){
		if(slow==fast){
			break;
		}
		slow=slow.next;
		fast=fast.next.next;
		
	}
	if(slow==fast){
	slow=head;
	while(slow.next!=fast.next){
		slow=slow.next;
		fast=fast.next;
	}
	fast.next=null;
	}
	return head;
}
}
