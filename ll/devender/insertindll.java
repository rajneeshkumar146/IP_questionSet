package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class insertindll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static void insert(Node head,int k,int x){
	Node prev=head;
	for(int count=1;count<=k;count++){
		head=head.next;
	}
	Node node=new Node(x);
node.next=prev.next;
node.prev=prev;
prev.next=node;
if(node.next!=null){
	node.next.prev=node;
}
}

}
