package Tree;

public class Populate_Inorder_Successor_for_all_nodes {
	class Node {
		int data;
		Node left, right, next;

		Node(int d) {
			data = d;
			left = right = next = null;
		}
	}

	static Node prev = null;

	public static void populateNext(Node root) {
		prev = null;
		populateNext_(root);
	}

	public static void populateNext_(Node root) {
		if (root == null)
			return;

		populateNext_(root.left);
		if (prev != null)
			prev.next = root;
		prev = root;

		populateNext_(root.right);

	}
}
