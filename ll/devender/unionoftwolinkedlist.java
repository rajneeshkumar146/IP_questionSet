package ll;

import java.util.HashSet;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class unionoftwolinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node un(Node h1, Node h2) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node n1 = h1;
		Node pre = h1;
		while (n1 != null) {
			set.add(n1.data);
			pre = n1;
			n1 = n1.next;
		}
		n1 = pre;
		while (h2 != null) {
			if (!set.contains(h2.data)) {
				Node next = h2.next;
				n1.next = h2;
				n1=h2;
				h2.next = null;
				h2 = next;
			} else {
				h2 = h2.next;
			}
		}
		h1 = mergesort(h1);
		return h1;
	}

	public static Node mergesort(Node n) {
		if (n == null || n.next == null) {
			return n;

		}
		Node middle = getmiddle(n);
		Node middlenext = middle.next;
		middle.next = null;// disconnect
		Node left = mergesort(n);
		Node right = mergesort(middlenext);
		Node sorted = merge(left, right);

		return sorted;
	}

	public static Node getmiddle(Node head) {
		Node slow = head;
		Node fast = head.next;
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
		} else {
			small = b;
			small.next = merge(a, b.next);
		}
		return small;
	}

}
