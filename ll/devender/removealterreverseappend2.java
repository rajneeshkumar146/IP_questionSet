package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class removealterreverseappend2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node vt(Node one) {
		if (one == null || one.next == null || one.next == null) {
			return null;
		}
		Node alter = one.next;
		one.next = one.next.next;
		alter.next = null;
		one = one.next;
		while (one != null && one.next != null) {
			Node alternext = one.next;
			Node onenext = one.next.next;
			one.next = onenext;// delete
			alternext.next = alter;// reverse
			alter = alternext;// move alter
			if (onenext != null) {
				one = onenext;// move one
			}
		}
		one.next = alter;
	}
}
