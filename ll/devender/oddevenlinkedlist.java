package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class oddevenlinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node  oddev(Node head) {
//		int count = 0;
//		Node hodd = null;
//		Node prev = null;
//		Node hev = null;
//		Node podd = null;
//		for (Node n = head; n != null;) {
//			Node next = n.next;
//			if (count % 2 == 0) {
//				if (hodd != null) {
//					hodd = n;
//					podd = n;
//				} else {
//					podd.next = n;
//					podd = n;
//					n.next=null;
//				}
//			} else {
//                    if(hev!=null){
//                    	hev=n;
//                    	prev=n;
//                    }else{
//                    	prev.next=n;
//                    	prev=n;
//                    	n.next=null;
//                    }
//                    
//			}
//			n=next;
//			count++;
//		}
//		
//			podd.next=hev;
//		return hodd;
        if(head==null){
            return null;
        }
       ListNode odd=head;
        ListNode even=head.next;
        ListNode evenhead=even;
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenhead;
        return head;
	}
}
