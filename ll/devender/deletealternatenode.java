package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class deletealternatenode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

public static Node deletealternode(Node head){
	Node prev=head;
	Node cur=head.next;
	while(prev!=null&&cur!=null){
		prev.next=cur.next;//delete cur node
		prev=prev.next;
		if(prev!=null){//checking cur ka next ka next is not equal to null
			cur=prev.next;
		}else{
			cur=null;
		}
	}
	return head;
}
}
