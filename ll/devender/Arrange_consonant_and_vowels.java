package ll;

public class Arrange_consonant_and_vowels {

	public static void main(String[] args) {

	}

	private static class Node {
		char data;
		Node next;

	}

	public static Node arcv(Node head) {
		Node vhead = null;
		Node prevv = null;
		Node prevc = null;
		Node chead = null;

		Node n = head;

		while (n != null) {

			if (n.data == 'a' || n.data == 'e' || n.data == 'i' || n.data == '0' || n.data == 'u') {
				if (vhead == null) {

					vhead = n;
					prevv = vhead;

				} else {
					prevv.next = n;
					prevv = n;
				}
			} else {
				if (chead == null) {

					chead = n;
					prevc = chead;
				} else {
					prevc.next = n;
					prevc = n;
				}
			}
			Node next = n.next;
			n.next = null;
			n = next;
		}
		if (vhead != null) {
			prevv.next = chead;
			return vhead;
		} else {
			return chead;
		}
	}
}
