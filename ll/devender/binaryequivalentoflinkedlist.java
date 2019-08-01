package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class binaryequivalentoflinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int func(Node head){
		int res=0;
		while(head!=null){
			res=(res*2+head.data)%1000000007;//just previous res get twice every time we ahead 
			head=head.next;		}
		return res;
	}

}
