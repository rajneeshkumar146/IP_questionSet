package ll;

public class insertinsorteddoublylinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
		int data;
		Node prev;
		Node next;
	}

	public static Node insert(Node head, Node add) {
		if (head == null) {
			return null;
		}
		if (head.data >= add.data) {
			add.next = head;
			add.next.prev = head;
			head = add;
		} else {
			Node cur = head;
			while (cur.next != null && cur.next.data < add.data) {
				cur = cur.next;
			}
			add.next = cur.next;
			add.prev = cur;
			cur.next = add;
			if (cur.next != null) {// if not the end
				add.next.prev = add;
			}
			
		}
		return head;
	}
}
