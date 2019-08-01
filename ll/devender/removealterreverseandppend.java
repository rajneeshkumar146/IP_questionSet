
package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class removealterreverseandppend {

	public static void main(String[] args) {
       
	}
public static void removeandreverse(Node head){
	Node prev=head;
	Node cur=head.next;
	Node sechead=null;
	Node secprev=null;
	while(prev!=null&&cur!=null){
		prev.next=cur.next;//delete cur node
		if(sechead==null){
			sechead=cur;
			secprev=cur;
		}else{
			secprev.next=cur;
			secprev=cur;
		}
		prev=prev.next;
		if(prev!=null){//checking cur ka next ka next is not equal to null
			
			cur=prev.next;
		}else{
			cur=null;
		}
	}
	Node tail=head;
	while(tail.next!=null){
		tail=tail.next;
	}
	Node t=reverse(sechead);
	tail.next=t;

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
