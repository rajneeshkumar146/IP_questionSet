package ll;

import ll.Add_two_numbers_II.ListNode;
import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class subtractioninlinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node mt(Node n1,Node n2){
	int one=0;
	int two=0;
	for(Node n=n1;n!=null;n=n.next){
		one=one*10+n.data;
	}
	for(Node n=n2;n!=null;n=n.next){
		two=two*10+n.data;
	}
	int sub=one>two?one-two:two-one;
	Node hd=new Node(sub%10);
	sub=sub/10;
	Node pre=hd;
	while(sub>0){
		Node n=new Node (sub%10);
		sub=sub/10;
		pre.next=n;
		pre=n;
		
	}
	
	Node head=reverse(hd);
	return head;
}
public static  Node reverse(Node n) {
	Node cur = n;
	Node prev = null;
    Node next = n.next;
	while (cur != null) {
		next = cur.next;
		cur.next = prev;
		prev = cur;
		cur = next;
    //System.out.println(prev.data);
	}
	return prev;
}

}
