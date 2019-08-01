package ll;

import java.util.HashSet;


public class removeduplicatesfromllinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class ListNode {
		int val;
		ListNode next;
	}

	public static ListNode remove(ListNode head) {
		HashSet<Integer> prev = new HashSet<>();
		HashSet<Integer> del = new HashSet<>();
		for (ListNode n = head; n != null; n = n.next) {
			if (prev.contains(n.val)) {
				del.add(n.val);
			} else {
				prev.add(n.val);
			}
		}

		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			if (del.contains(cur.val)) {
				if (head.val == cur.val) {
					head = head.next;
					cur = head;
				} else {
					ListNode next = cur.next;
					pre.next = cur.next;
					cur = next;
				}
			} else {
				pre = cur;
				cur = cur.next;
			}
		}
		return head;
	}
}
