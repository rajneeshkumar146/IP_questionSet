package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class modularnode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int val(Node head,int k) {
		Node l=null;
		int count=0;
		for (Node n = head; n!=null; n = n.next) {
			count++;
			if(count%k==0){
				l=n;
			}
			
		}
		if(l!=null){
			return l.data;
		}else{
		return -1;}
	}
	
}
