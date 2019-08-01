package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class deletewithoutheadpointer {

	public static void main(String[] args) {
     
	}
public static void delete(Node n){
	
	n.next.data=n.data;
	n.next=n.next.next;
}
}
