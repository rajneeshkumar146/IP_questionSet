package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class removeduplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static int removeduplicate(Node head){
	Node traversal=head;
	while(traversal!=null){
		Node run=traversal;
		while(run!=null&&traversal.data==run.data){
		run=run.next;
		
		}
		traversal.next=run;
		traversal=traversal.next;
	}
	return head;
}
}
