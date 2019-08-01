package ll;

import ll.Absolute_list_string.Node;

public class comparetwolinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Node {
		int data;
		Node next;
	}

	public static int comp(Node node1, Node node2) {
		if (node1 == null && node2 == null) {
			return 0;
		}
		while (node1 != null && node2 != null && node1.data == node2.data) {//check until not null adn data being same
			node1 = node1.next;
			node2 = node2.next;
		}
		// compare if both list left
		if (node1 != null && node2 != null) {
			return node1.data > node2.data ? 1 : -1;
		}
		// if node2 finish then obviously 1
		if (node1 != null && node2 == null) {
			return 1;
		}
		// 1 finish same chars and 2 left
		if (node1 == null && node2 != null) {
			return -1;
		}
		return 0;
	}
}
