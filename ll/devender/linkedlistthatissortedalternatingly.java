package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class linkedlistthatissortedalternatingly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node v(Node head) {
		Node one = head;
		Node prone = head;
		Node two = null;
		Node pretwo = null;
		Node cur = head.next;
		int i = 0;
		while (cur != null) {
			Node next = cur.next;
			if (i % 2 == 0) {
				if (two == null) {
					two = cur;
					pretwo = cur;
					cur.next = null;
				} else {
					pretwo.next = cur;
					pretwo = cur;
					cur.next = null;
				}
			} else {
				prone.next = cur;
				prone = cur;
			}
			cur = next;
		}
Node v=reverse(two);
Node h=merge(one, v);
return h;
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
