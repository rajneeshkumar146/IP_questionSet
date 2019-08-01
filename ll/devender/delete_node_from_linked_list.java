package ll;

import ll.Absolute_list_string.Node;

public class delete_node_from_linked_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static class Node {
		int data;
		Node next;
	}
	public static Node delete(Node head,int key){
	if(head==null){//if linkedlist already empty
		return null;
	}
	Node  temp=head;
	Node prev=null;
	while(temp!=null&&temp.data!=key){//traverse until you get the the desired node
		prev=temp;
		temp=temp.next;
	}
	if(temp==null){//key not found
		return head;
	}
	else{
		prev.next=temp.next;//delete temp
		return head;
	}
	}
}
