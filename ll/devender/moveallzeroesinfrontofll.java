package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class moveallzeroesinfrontofll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static int moveallzeroes(Node head){
	if(head==null){
		return 0;
	}
Node cur=head.next;
Node prev=head;
while(cur!=null){
	if(cur.data==0){
		
		prev.next=cur.next;
		cur.next=head;
		head=cur;
		cur=prev.next;
	}else{
		prev=cur;
		cur=cur.next;
		
	}
	
	
}
return head;
}
}
