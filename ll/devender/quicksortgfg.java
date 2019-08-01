package ll;

public class quicksortgfg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node quickSort(Node node) {
		node = quickSortRec(node, getTail(node));

		return node;
	}

	public static Node getTail(Node n) {
		while (n != null && n.next != null)
			n = n.next;

		return n;
	}

	static class Res {
		Node newHead = null, newEnd = null;
	}

	public static Node quickSortRec(Node head, Node last) {
		if (head == null || head == last)
			return head;

		Res r = new Res();
		Res s = new Res();
		Node pivot = partition(head, last, r, s);

		if (r.newHead != pivot) {
			Node tmp = r.newHead;
			while (tmp.next != pivot)
				tmp = tmp.next;
			tmp.next = null;

			r.newHead = quickSortRec(r.newHead, tmp);
			tmp = getTail(r.newHead);
			tmp.next = pivot;

		}
		pivot.next = quickSortRec(pivot.next, s.newEnd);
		return r.newHead;
	}

	public static Node partition(Node head, Node last, Res r, Res s) {
		Node pivot = last;
		Node prev = null, cur = head, tail = pivot;

		while (cur != pivot) {
			if (cur.data < pivot.data) {

				if (r.newHead == null)
					r.newHead = cur;

				prev = cur;
				cur = cur.next;
			} else {

				if (prev != null)
					prev.next = cur.next;
				Node tmp = cur.next;
				cur.next = null;
				tail.next = cur;
				tail = cur;
				cur = tmp;
			}
		}

		if (r.newHead == null)
			r.newHead = pivot;

		s.newEnd = tail;

		return pivot;
	}

}
