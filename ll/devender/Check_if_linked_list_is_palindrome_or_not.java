package ll;


public class Check_if_linked_list_is_palindrome_or_not {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static class Node {
		int data;
		Node next;
	}
	Node left;
    boolean isPalindrome(Node head) 
    {left=head;
    return ispalindrome(head);
        //Your code here
    }   
    public  boolean ispalindrome(Node n){
	
	if(n==null){
		return true;
	}
	boolean nextresult=ispalindrome(n.next);
	if(nextresult==false||left.data!=n.data){
		return false;
	}
		left=left.next;
	return true;
}}
