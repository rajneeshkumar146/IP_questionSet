package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class reversedoubly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node l(Node x){
	Node cur=x.next;
	Node temp=null;
	x.next=null;
	x.prev=cur;
	while(cur!=null){
		 temp=cur.prev;
		cur.prev=cur.next;
		cur.next=temp;
		cur=cur.prev;
	}
if(temp!=null){
	x=temp.prev;
}
return x;
}
}
