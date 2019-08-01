package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class mergesortfordoublyll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static mergesortdoubly(Node head){
	
}
public static Node mergesort(Node n) {
	if (n == null || n.next == null) {
		return n;

	}
	Node middle = getmiddle(n);
	Node middlenext = middle.next;
	middle.next = null;// disconnect
	Node left = mergesort(middle);
	Node right = mergesort(middlenext);
	Node sorted = merge(left, right);
	return sorted;
}

public static Node getmiddle(Node head) {
	Node slow = head;
	Node fast = head;
	while (fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
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
		small.next.prev=small;
	} else {
		small = b;
		small.next = merge(a, b.next);
		small.next.prev=small;
	}
	return small;
}

}
