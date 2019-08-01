package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class mergeksortedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node mergek(Node []arr){
	int i=1;
	Node head=arr[0];
	while(i<arr.length){
		head=merge(head, arr[i]);
	}
	return head;
}
public static Node merge(Node a, Node b) {
	if (a == null) {
		return b;
	}
	if (b == null) {
		return a;
	}
	Node small;
	if (a.data < b.data) {
		small = a;
		small.next = merge(a.next, b);
	} else {
		small = b;
		small.next = merge(a, b.next);
	}
      return small;
}
}
