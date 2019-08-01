package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class modifylinkedlist {

	public static void main(String[] args) {
	

	}

	 Node modify(Node node) {
			Node middle = getmiddle(node);
			Node middlenext=middle.next;
			middle.next = null;
			Node nextrev = reverse(middle*
					next);
			Node sub = nextrev;
			Node first = node;
			while (sub != null) {
				first.data = first.data - sub.data;
				first = first.next;
				sub = sub.next;
			}
			Node middlenext = reverse(nextrev);
			middle.next = middlenext;
			return node;
		}

	 Node getmiddle(Node head) {
			Node slow = head;
			Node fast = head.next;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
		}

	 Node reverse(Node n) {
			Node cur = n;
			Node prev = null;
			Node next = null;
			while (cur != null) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
				// System.out.println(prev.data);
			}
			return prev;
		}

}
