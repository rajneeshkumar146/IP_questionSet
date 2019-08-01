package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class mergeallintoanotherllatalternateposition {

	public static void main(String[] args) {

	}

	public static Node anlist(Node n1, Node n2) {
		Node original = n1;
		Node process = n2;
		while (original != null && process != null) {
			Node ornext= n1.next;
			Node  prnext= n2.next;
			process.next=ornext;
			original.next=process;
			original=ornext;
			process=prnext;
		}
		n2=original;
	}
}
