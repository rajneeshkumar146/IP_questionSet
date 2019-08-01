package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class findnkthinll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int cyle(Node head, int k) {
		int count = 0;
		for (Node n = head; n != null; n = n.next) {
			count++;
		}
		int val = (int) Math.ceil((float) count / k);
		Node cur = head;
		for (int i = 0; i < val; i++) {
			cur = cur.next;
                
		}
      return cur.data;
	}
}
