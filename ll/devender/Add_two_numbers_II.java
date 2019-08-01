package ll;


public class Add_two_numbers_II {

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

	public  ListNode addTwoNumbers(ListNode n1, ListNode n2) {
		n1=reverse(n1);
		n2=reverse(n2);
		int carry = 0;
		int sum = 0;
		ListNode head=null;
		ListNode prev=null;
		while (n1 != null || n2 != null) {
			int ldata = n1 != null ? n1.val : 0;
			int sdata = n2 != null ? n2.val : 0;
			sum =  ldata + sdata + carry;
			carry = sum / 10;
			sum = sum % 10;
			if (head == null) {
				head = new ListNode(sum);
				prev = head;
			} else {
				ListNode n = new ListNode(sum);
				prev.next = n;
				prev = n;
			}
            if(n1!=null){
            n1=n1.next;}
            if(n2!=null){
            n2=n2.next;}
		}
		if(carry!=0){
			ListNode n=new ListNode(carry);
			prev.next=n;
		}
		
		return reverse(head);
	}
	public  ListNode reverse(ListNode n) {
		ListNode cur = n;
		ListNode prev = null;
		ListNode next = n.next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
        //System.out.println(prev.data);
		}
		return prev;
	}


}
