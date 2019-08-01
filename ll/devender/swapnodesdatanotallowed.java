package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class swapnodesdatanotallowed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void swap(Node head, int n, int k) {
		if (n < k || 2 * k - 1 == n) {
			return;
		}
		Node kthfromfirst = head;
		int i = 1;
		Node kthpre = null;
		while (i < k) {
			kthpre = kthfromfirst;
			kthfromfirst = kthfromfirst.next;
			i++;
		}
		Node kthfromlastpre = null;
		Node kthfromlast = head;
		i=1;
		while (i < n-k+1) {
			kthfromlastpre = kthfromlast;
			kthfromlast = kthfromlast.next;
			i++;
		}
		if (kthpre != null) {
			kthpre.next = kthfromlast;
		}
		if (kthfromlastpre != null) {
			kthfromlastpre.next = kthfromfirst;
		}
		Node temp = kthfromfirst.next;
		kthfromfirst.next = kthfromlast.next;
		kthfromlast.next = temp;
		if (k == 1) {
			head = kthfromlast;
		}
		if (k == n) {
			head = kthfromfirst;
		}
	}
}
