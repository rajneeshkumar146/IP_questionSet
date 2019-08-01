package ll;

import ll.Absolute_list_string.Node;

public class CircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Node {
		int data;
		Node next;
	}

	public static boolean checkcurcular(Node n) {
		Node head=n;
		if (n == null) {
			return true;
		}
		n=n.next;
		while (n != null && n != head) {
			n = n.next;
		}
		if(n==head){//if loops stops due to head come then circular
			return true;
		}else{
			return false;
		}
			}
}
