package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class sortllof012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static  func(Node head){
	int count1=0;
	int count2=0;
	int count0=0;
	for(Node n=head;n!=null;n=n.next){
		if(n.data==0){
			count0++;
		}else if(n.data==1){
			count1++;
		}else{
			count2++;
		}
	}
	for(Node n=head;n!=null;n=n.next){
		if(count0>0){
			n.data=0;
			count0--;
		}else if(count1>0){
			n.data=1;
			count1--;
		}else{
			n.data=2;
			count2--;
		}
	}
	return head;
}
}
