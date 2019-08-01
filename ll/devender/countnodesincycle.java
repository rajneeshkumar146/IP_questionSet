package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class countnodesincycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int totalcycle(Node slow) {
		Node s = slow.next;
		int count = 0;
		while (s != slow) {
			count++;
		}
		return count;

	}

	public static int floydcycle(Node head) {
		Node slow = head;
		Node fast = head;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return totalcycle(slow);
			}
		}
		return 0;
	}
}
