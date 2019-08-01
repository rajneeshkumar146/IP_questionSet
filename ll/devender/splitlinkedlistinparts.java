package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class splitlinkedlistinparts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void mt(ListNode head, int n, int k) {
		ListNode[] arr = new ListNode[n];
		int width = n / k;
		int rem = n % k;// parts having extra
		Node cur=head;
		for (int i = 0; i < k; i++) {
			ListNode lt=new ListNode(0);
			Node vrl=lt;
		for(int j=0;j<width+(i<rem?1:0);j++){
			vrl.next=new ListNode(cur.val);
			vrl=vrl.next;
			if(cur!=null){
				cur=cur.next;
			}
			ans[i]=lt.next;
		}
					}
	}
}
