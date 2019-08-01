package ll;


public class Add_two_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int d) {
			this.val = d;

		}
	}

	public ListNode addTwoNumbers(ListNode n1, ListNode n2) {
		int carry = 0;
		int sum = 0;
		ListNode head = null;
		ListNode prev = null;
		while (n1 != null || n2 != null) {
			int ldata = n1 != null ? n1.val : 0;
			int sdata = n2 != null ? n2.val : 0;
			sum = ldata + sdata + carry;//generate sum
			carry = sum / 10;//generate new carry
			sum = sum % 10;//generate value
			//make new node and updation
			if (head == null) {
				head = new ListNode(sum);
				prev = head;
			} else {
				ListNode n = new ListNode(sum);
				prev.next = n;
				prev = n;
			}
			if (n1 != null) {//if n1 left update it
				n1 = n1.next;
			}
			if (n2 != null) {//if n2 left update it
				n2 = n2.next;
			}
		}
		if (carry != 0) {
			ListNode n = new ListNode(carry);//last mein if carry left make new node
			prev.next = n;
		}

		return head;
	}

	

}
