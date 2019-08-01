package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class deletenodeincll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node func(Node head, int x) {
		Node cur = head;
		Node prev = null;
		while (cur.next != head && cur.data != key) {

			prev = cur;
			cur = cur.next;
		}
		
		if (cur.next == head) {// single node
			head = null;
			return null;
		}
		
       if(cur==head){
    	   prev=head;
    	   while(prev.next!=head)
    		   prev=prev.next;
    		   head=cur.next;
    	   prev.next=head;
       }  else if(){
    	   
       }   
	}
}
