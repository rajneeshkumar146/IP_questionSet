package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class delete_nnodes_after_mnodesoflist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node func(Node head, int n, int m) {
		Node cur = head;
		while (cur != null) {
			for (int i = 1; i < m; i++) {// traverse till you are at mth node
				cur = cur.next;
			}
			Node t = cur.next;
			for (int i = 1; i <= n; i++) {// traverse till you are at n+1 node
											// from mth node
				t = t.next;
			}
			cur.next = t;// delete all n nodes netween
			cur = t;
		}
		return head;
	}
}
