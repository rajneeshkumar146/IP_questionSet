package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class circularlinkedlistintotwohalves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node llist(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast.next.next == head) {// in even list
			fast = fast.next.next;
		}
		if (head.next != null) {
			head2 = slow.next;
		}
		head1 = head;
		// make second circular
		fast.next = slow.next;
		// make first circular
		slow.next = head;
	}

}
