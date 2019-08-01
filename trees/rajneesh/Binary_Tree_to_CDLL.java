package Tree;

public class Binary_Tree_to_CDLL {
	static class Node {
		Node left, right;
		int data;

		Node(int d) {
			data = d;
			left = right = null;
		}

	}

	// method1.=======================================================================

	public Node treeToDoublyList(Node root) {

		head = null;
		prev = null;
		treeToDoublyList_(root);
		if (head != null) {
			prev.right = head;
			head.left = prev;
		}
		return head;

	}

	Node prev = null;
	Node head = null;

	public void treeToDoublyList_(Node node) {
		if (node == null)
			return;

		Node left = node.left;
		Node right = node.right;

		treeToDoublyList_(left);
		if (head == null) {
			head = node;
		} else {
			prev.right = node;
			node.left = prev;
		}
		prev = node;

		treeToDoublyList_(right);

	}

}
