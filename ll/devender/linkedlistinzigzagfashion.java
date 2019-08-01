package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class linkedlistinzigzagfashion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static void fashion(Node head){
	boolean flag=true;
	Node cur=head;
	
	while(cur!=null&&cur.next!=null){
		if(flag){
			if(cur.data>cur.next.data){
				int temp=cur.data;
				cur.data=temp;
				cur.next.data=temp;
			}
		}else{
			if(cur.data<cur.next.data){
				int temp=cur.data;
				cur.data=temp;
				cur.next.data=temp;
			}
		}
		flag=!flag;
		cur=cur.next;
	}
}
}
