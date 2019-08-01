package ll;

public class insertionsort {

	public static void main(String[] args) {

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	ListNode result;

	public ListNode insertionSortList(ListNode head) {
		result = null;
		ListNode cur = head;

		while (cur != null) {
			ListNode nt = cur.next;
			insert(cur);
			cur = nt;
		}
		return result;
	}

	public void insert(ListNode add) {
		if (result == null || result.val >= add.val) {
			add.next = result;
			result = add;
		} else {
			ListNode cur = result;
			while (cur.next != null && cur.next.val < add.val) {
				cur = cur.next;
			}
			add.next = cur.next;
			cur.next = add;
		}

	}
}
