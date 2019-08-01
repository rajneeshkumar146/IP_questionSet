package ll;

public class Absolute_list_string {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in)

	}

	private static class Node {
		int data;
		Node next;
	}

	public static Node sort(Node n) {
		Node prev = n;
		for (Node l = n.next; l != null; l = l.next) {//traversing
			if (l.data < prev.data) {//means this is at wrong index
				prev.next = l.next;//delete 
				l.next = n;//make it first node
				n = l;//update first node
				l = prev;
			} else {
				prev = l;
			}

		}
		return n;//return new head
	}

}
