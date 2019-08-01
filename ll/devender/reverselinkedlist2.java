package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class reverselinkedlist2 {

	public static void main(String[] args) {

	}
public static Node reverse(Node head,int k,Node nth){
	Node cur=head;
	Node pre=null;
	Node next=null;
	int count=0;
	while(cur!=null&&count<k){
		next=cur.next;
		cur.next=pre;
		pre=cur;
		cur=next;
		count++;
	}head.next=nth;
	return pre;
}
	public static Node list(Node head, int n, int m) {
		int count = 1;
		Node cur = head;
		
		while (cur != null && count < m-1) {
			count++;
		cur = cur.next;
		}
		Node nth=cur;
		while(count<n){
			nth=nth.next;
			count++;
		}
		cur.next=reverse(cur.next,n-m+1,nth);
				
		return head;
		
		
	}
}
