package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class multiply_two_linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int multiply(Node one, Node two) {
		int first = 0;
		int sec=0;
		while (one != null) {
			first = first * 10 + one.data;
			one = one.next;
		}
		while (two != null) {
			sec=sec*10+two.data;
         two=two.next;
		}
		return first*sec;
	}
}
