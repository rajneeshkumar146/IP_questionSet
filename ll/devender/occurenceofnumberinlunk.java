package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class occurenceofnumberinlunk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int freq(Node head, int k) {
		int count=0;
		for (Node n = head; n != null; n = n.next) {
			if (n.data == k) {
				count++;
			}
		
		}
		return count;
	}
}
