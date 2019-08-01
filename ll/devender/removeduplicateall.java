package ll;

import java.util.HashSet;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class removeduplicateall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int mi(int st, int val) {
		HashSet<Integer> vs = new HashSet<>();
		Node n = head;
		Node prev = n;
		HashSet<Integer> dup = new HashSet<>();
		while (n != null) {
			int val = n.data;
			if (vs.contains(n.data)) {
				dup.ass(n.data);
				// prev.next=n.next;
			} else {
				vs.add(n.data);
				prev = n;
			}
			n = n.next;
		}
		n = head;
		while (n != null) {
			int val1 = n.data;
			if (dup.contains(val1)) {
             prev.next=
			}
		}
		return head;
	}
}
