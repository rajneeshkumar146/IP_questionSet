package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class rearrangellinplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static class heapmover{
		Node hd;
	}
public static Node fold(Node hd){
	heapmover hp=new heapmover();
	hp.hd=hd;
	int size=0;
	for(Node n=hd;n!=null;n=n.next){
		n=n.next;
		size++;
	}
	foldhelp(hd,hp,size,0);
}
public static Node foldhelp(Node hd,heapmover h2,int size,int floor){
	if(hd==null){
		return;
	}
	Node h=foldhelp(hd.next,h2,size,floor+1);
	if(floor>size/2){
		Node temp=h2.hd.next;
		h2.hd.next=hd;
		hd.next=temp;
		h2.hd=temp;
	} 
	else if(floor==size/2){
		hd.next=null;
		
	}
}
}
