package ll;

import ll.Absolute_list_string.Node;

public class deleteallocurencesoflinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static class Node {
		int data;
		Node next;
	}
public static Node func(Node head,int key){
Node temp=head;
	while(temp!=null&&temp.data==key){//delete occurence in continuation with head
		head=head.next;
		temp=head;
	}
	Node prev=null;
	while(temp!=null){
		while(temp!=null&&temp.data!=key){//traverse until you find key
			prev=temp;
			temp=temp.next;
		}
		if(temp==null){//key not find 
			return head;
		}
		//key found
		prev.next=temp.next;//delete
		temp=prev.next;
		
	}
	return head;
}
}
