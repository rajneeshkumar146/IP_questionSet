package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class flatteningalinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 Node flatten(Node l)
	    {
		if(l==null||l.next==null){
			return l;
		}
		l.next=flatten(l.next);
		return merge(l, l.next);

	    }
	    public static Node merge(Node a,Node b){
		if(a==null){
			return b;
		}
		if(b==null){
			return a;
		}
		Node small;
		if(a.data<b.data){
			small=a;
		small.bottom=merge(a.bottom, b);
		}else {
			small=b;
			small.bottom=merge(a,b.bottom);
					
		}
		return small;
	}
	    }
