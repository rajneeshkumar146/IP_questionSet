package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class pairwiseswap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node ts(Node nv, int ter) {
		Node head=nv;
            while(nv!=null&&nv.next!=null){
            	int temp=nv.data;
            	nv.data=nv.next.data;
            	nv.next.data=temp;
            	nv=nv.next.next;
            }
            return head;
	}
}
