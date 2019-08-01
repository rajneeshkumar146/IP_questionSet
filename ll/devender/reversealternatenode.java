package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class reversealternatenode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node revkalternate(Node head,int k){
	Node cur=head;
	Node next=null;
	Node pre=null;
	int count=0;
	while(cur!=null&&count<k){
		next=cur.next;
		cur.next=pre;
		pre=cur;
		cur=next;
		count++;
	}
	if(head!=null){
		head.next=cur;
	}
	while(cur!=null&&count<k-1){
		cur=cur.next;
		count++;
	}
	
	if(cur!=null){
		cur.next=revkalternate(cur.next,k);
	}
	return pre;//become head
}
}
