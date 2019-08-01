package ll;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class reversealinkedlistingroupofsizek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Node  reverse(Node head,int k){
	
    ListNode cur=head;
ListNode next=null;
ListNode prev=null;
int count=0;
    int count2=0;
    ListNode nt=head;
    while(count2<k&&nt!=null){
        count2++;
        nt=nt.next;
    }
    boolean f=true;
    if(count2==k){
        f=false;
    }
while(cur!=null&&count<k&&!f){
	next=cur.next;
	cur.next=prev;
	prev=cur;
	cur=next;
	count++;
}
if(next!=null){
	head.next=reverseKGroup(next, k);
	}
    if(!f){
return prev;}else{
        return head;
    }//newhead
}
}
