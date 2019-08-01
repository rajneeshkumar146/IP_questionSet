package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class removeeverykthnode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node st(Node n,int k){
  if(k==1){
	  return null;
  }
  int count=0;
  Node cur=n;
  Node prev=null;
  
  while(cur!=null){
	  count++;
	  if(count==k){
		 Node temp= cur.next;
		  prev.next=cur.next;
		 cur=temp;
		 count=0;
	  }
	  
	  else{
		  
		  prev=cur;
	 	  cur=cur.next;}
  }
  return n;
}
}
