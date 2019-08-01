package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class mergetwosortedlistinreverseorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static  Node reverse(Node n) {
		Node cur = n;
		Node prev = null;
		Node next = n.next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
        //System.out.println(prev.data);
		}
		return prev;
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
