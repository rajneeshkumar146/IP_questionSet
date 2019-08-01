package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class partitionlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void partitionlist(Node n, int key) {

		int i = -1;
		int j = 0;
		Node preserved = null;
		Node h = n;
		while (h != null) {
          if(h.data<key){
        	 
        	  if(preserved.next!=null){
        		  preserved=preserved.next;
        		 int temp=preserved.data;
        		 preserved.data=h.data;
        		 h.data=temp;
        	  }
        	  
          }
          h=h.next;
		}
	}
}
