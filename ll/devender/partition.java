package ll;

public class partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode partition(ListNode n, int x) {
		ListNode lefthead = null;
		ListNode righthead = null;
		ListNode right = null;
		ListNode left = null;
		ListNode head = n;
		while (head != null) {
			if (head.val < x) {
				if (lefthead == null) {
					lefthead = left = head;
				} else {
					left.next = head;
					left = head;

				}
			} else {
				if (righthead == null) {
					righthead = right = head;
				} else {
					right.next = head;
					right = head;}

			}
			head=head.next;

		}
if(right!=null){
	right.next=null;
}
		if (left != null) {
			left.next = righthead;
			return lefthead;
		} else {
			return righthead;
		}
	}
}
