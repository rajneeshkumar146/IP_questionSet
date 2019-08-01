package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class floydcycledetectionalgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int cycle(Node head) {
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return 1;
			}
		}
		return 0;
	}
}
