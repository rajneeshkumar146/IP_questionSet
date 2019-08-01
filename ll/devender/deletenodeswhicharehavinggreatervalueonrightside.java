package ll;

import java.time.format.ResolverStyle;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class deletenodeswhicharehavinggreatervalueonrightside {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void delete(Node head) {
		Node revhead = reverse(head);
		int max = revhead.data;
		Node cur = head.next;
		Node prev = head;
		while (prev != null && cur != null) {
			if (cur.data < max) {
				prev.next = cur.next;
				cur=cur.next;
				
			} else {
				max = cur.data;
				prev = cur;
				cur = cur.next;
			}
			
		}
     head=reverse(head);
     
	}

	public static Node reverse(Node node) {
		  Node prev = null; 
	        Node current = node; 
	        Node next = null; 
	        while (current != null) { 
	            next = current.next; 
	            current.next = prev; 
	            prev = current; 
	            current = next; 
	        } 
	        node = prev; 
	        return node;
	}

}
