package graphs;

public class FlattenADoublyLikedList {

	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node() {

		}

		public Node(int _val, Node _prev, Node _next, Node _child) {
			val = _val;
			prev = _prev;
			next = _next;
			child = _child;
		}
	}

	Node res = new Node(-1, null, null, null);
	Node curr = res;

	public Node flatten(Node head) {

		if (head == null) {
			return head;
		}

		dfs(head);
		res = res.next;
		res.prev = null;
		return res;

	}

	public void dfs(Node node) {

		if (node == null) {
			return;
		}

		Node temp = new Node(node.val, null, null, null);
		temp.prev = curr;
		curr.next = temp;
		curr = curr.next;

		if (node.child == null) {
			dfs(node.next);
		} else {
			Node child = node.child;
			node.child = null;
			dfs(child);
			dfs(node.next);
		}

	}

}