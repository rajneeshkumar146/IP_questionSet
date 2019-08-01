package ll;

public class lengthoflongestpalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
		int data;
		Node next;
	}

	public static int common(Node first, Node sec) {
		int count = 0;
		while (first != null && sec != null && first.data == sec.data) {
			count++;
			first = first.next;
			sec = sec.next;
		}
		return count;
	}

	public static int lengthoflongest(Node head) {
		Node prev = null;
		Node cur = head;
		int result = 0;
		while (cur != null) {
			Node next = cur.next;
			cur.next = prev;
			prev = cur;
			// check for odd length exclude cur as middle
			result = Math.max(result, common(prev, next));
			// check for even
			result = Math.max(result, common(prev, next));
			prev = cur;
			cur = next;

		}
		return result;
			}
}
