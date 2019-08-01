package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class rotatealibkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void mt(Node n, int k) {
		int count = 1;
		Node cur = n;
		while (count < k - 1) {
			cur = cur.next;
			count++;
		}
		Node kthmin1 = cur;

		while (cur.next != null) {
			cur = cur.next;
		}
		Node tail = cur;
		tail.next = n;
		n = kthmin1.next;
		kthmin1.next = null;
		
	}
}
