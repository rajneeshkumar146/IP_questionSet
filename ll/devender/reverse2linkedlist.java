package ll;

public class reverse2linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class ListNode {
		int val;
		ListNode next;
	}

	private static ListNode reverse(ListNode head, int k, ListNode nthnext) {
		ListNode cur = head;
		ListNode pre = null;
		ListNode next = null;
		int count = 0;
		while (cur != null && count < k) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			count++;
		}
		head.next = nthnext;
		return pre;
	}

	public static ListNode reverseii(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}
		ListNode cur = head;
		int count = 1;
		while (cur != null && count < m - 1) {
			cur = cur.next;
			count++;
		}
		ListNode mthprev = cur;

		while (cur != null && count <= n) {
			cur = cur.next;
			count++;
		}
		ListNode nthnext = cur;
		if (mthprev.next != null) {
			ListNode l = reverse(mthprev, n - m + 1, nthnext);
			mthprev.next = l;
		}

		return head;
	}
}
