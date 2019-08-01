package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class swapkthnodefromends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class mt {
		int val;
		Node left;
	}

	private static Node func(Node head, int n, int k) {
		if (n < k || 2 * k - 1 == n) {
			return head;
		}
		mt m = new mt();
		m.val = 0;
		m.left = head;
		swapnodes(head, k, m);
		return head;
	}

	public static void swapnodes(Node n, int k, mt m) {
		if (n == null) {
			return;
		}

		swapnodes(n.next, k, m);
		m.val++;
		m.left = m.left.next;
		if (m.val == k) {
			int temp = m.left.data;
			int val = n.data;
			m.left.data = val;
			n.data = temp;
		}
	}
}
