package ll;

import java.util.HashSet;

import ll.Addonetoanumberrepresentaslinkedlist.Node;

public class removeelements {

	public static void main(String[] args) {

	}
public static Node remove(){
	while(head!=null&&head.val==val){
        head=head.next;
    }
        ListNode n=head;
        ListNode prev=head;
        while(n!=null){
            if(n.val==val){
                prev.next=n.next;
                
            }else{
                prev=n;
            }
            n=n.next;
        }
        return head;
    }}
