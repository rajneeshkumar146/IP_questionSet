package ll;

public class Addonetoanumberrepresentaslinkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Node {
		int data;
		Node next;

		Node(int val) {
			this.data = val;
		}
	}

	public Node reverse(Node n) {
		Node cur = n;
		Node prev = null;
		Node next = n.next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;

		}
		return prev;
	}

	public Node addOne(Node n) {

		Node head = n;
		int carry = 1;// since add 1 meant as initial carry 1
		int  sum = 0;
		Node temp = head;
		while (head != null) {
			sum = carry + head.data;// add prev carry
			carry = sum >= 10 ? 1 : 0;// generate new carry
			sum = sum % 10;// new value

			head.data = sum;// update
			temp = head;// for storing previous
			head = head.next;
		}

		if (carry != 0) {
			Node newcarryhead = new Node(carry);//if last carry left
			temp.next = newcarryhead;//prev next update 

		}
		return reverse(n);//now reverse to get the required number

	}
}
