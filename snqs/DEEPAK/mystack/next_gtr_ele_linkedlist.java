package mystack;

public class next_gtr_ele_linkedlist {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 public int[] nextLargerNodes(ListNode head) {
	        if (head == null) return null;
	int count = 1;
	ListNode current = head;
	while(current.next != null){
	count++;
	current = current.next;
	}
	int[] ans = new int[count];
	ListNode curr = head, temp = curr.next;
	for (int i = 0; i< count; i++){
	while (temp != null && temp.val <= curr.val)
	    temp = temp.next;
	if (temp != null) 
	    ans[i] = temp.val;
	curr = curr.next;
	if(curr != null) 
	    temp = curr.next;
	}
	return ans;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
