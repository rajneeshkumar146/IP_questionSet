package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class insertintocyclic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static int insert(int val,Node head){
	if(head==null){
		Node n=new Node(val,null);
		n.next=n;
		return n;
	}else{
		
		Node max=head;
		Node cur=head;
		while(cur!=null){
			if(cur.data<=val&&cur.next.data>=val){
				Node tobeadd=new Node(val,cur.next);
				cur.next=tobeadd;
				return head;
			}
			else if(cur.val>=max){
				max=cur;
			}else if(cur.next.equals(head.next)){
				break;
			}		
			}
		Node add=new Node(val,max.next);
		max.next=add;
		return head;
	}
}
}
