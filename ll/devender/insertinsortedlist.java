package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class insertinsortedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node insert(Node head,int cak){
	 if(x<head.data){
         Node n=new Node(x);
         n.next=head;
         head=n;
     }else{
     Node cur=head;
while(cur.next!=null&&cur.next.data<cak){
	cur=cur.next;
}
Node nt=new Node(cak);
Node next=cur.next;
cur.next=nt;
nt.next=next;}
while(head!=null){
 System.out.print(head.data+" ");
 head=head.next;
}
}
}
