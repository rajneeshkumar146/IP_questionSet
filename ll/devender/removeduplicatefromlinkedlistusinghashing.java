package ll;

import java.util.HashSet;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class removeduplicatefromlinkedlistusinghashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int remove(Node head) {
		HashSet<Integer> vs = new HashSet<>();
		Node n=head;
		Node prev=n;
		while (n != null) {
			int val=n.data;
			if (vs.contains(n.data)) {
				prev.next=n.next;
			}else{
				vs.add(n.data);
				prev=n;
			}
			n = n.next;
		}
		return head;
	}
}
