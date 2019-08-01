package ll;

public class intersectionofyshapedll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Node {
		int data;
		Node next;
	}

	public static int func(Node on1, Node two) {
		int size1 = 0;
		int size2 = 0;
		Node o = on1;
		Node t = two;
		while (o != null) {
			o = o.next;
			size1++;
		}
		while (t != null) {
			t = t.next;
			size2++;
		}
		int diff = size1 - size2;
		if (size1 > size2) {
			while (diff > 0) {
				on1 = on1.next;
				diff--;
			}
		} else {
			while (diff > 0) {
				two = two.next;
				diff--;
			}
		}
		while (on1 != null && two != null) {
			if (on1.data == two.data) {
				return on1.data;
			}
			on1 = on1.next;
			two = two.next;
		}
		return -1;
	}
}
