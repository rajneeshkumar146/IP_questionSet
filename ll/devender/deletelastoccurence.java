package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class deletelastoccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node func(Node head,int key){
	Node delete=null;
	Node temp=head;
	while(temp!=null){//traverse until last occurence
		if(key==temp.data){
			delete=temp;
		}
		temp=temp.next;
	}
	
	if(delete!=null){//node to be deleted exist
		if(delete.next==null){//tail of list
			delete=null;
		}else{
		delete.data=delete.next.data;//copy next item
		delete.next=delete.next.next;//delete next}
	}
}
	return head;

}}
