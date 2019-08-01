package ll;

public class linkedlistincycle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public ListNode detectCycle(ListNode head) {
	       ListNode slow = head;
			ListNode fast = head;
	        
			while (slow != null && fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow == fast) {
				slow=head;
	                while(slow!=fast){
	                    slow=slow.next;
	                    fast=fast.next;                }
	                return slow;
	            
				}
	            
			}
			
			
			return null;
	    }
}
