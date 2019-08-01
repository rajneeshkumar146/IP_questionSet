package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class deletenodeindll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node ll(Node head, int x) {
		if (head == null) {// for empty list
			return null;
		}
		if(head.data==x){//
			head=head.next;
			head.prev=null;
			return head;
		}
		Node delete = head;
		while (delete != null && delete.data != x) {
			delete = delete.next;
		}
		if (delete == null) {// not found the delete node
			return head;
		}
		
		if (delete.prev != null) {//if not head then only
			delete.prev.next = delete.next;
		}
		if (delete.next != null) {//if not tail then only
			delete.next.prev = delete.prev;
		}
		return head;
	}
}
