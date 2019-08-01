package Tree;

public class Binary_Tree_to_DLL {
	static class Node {
		Node left, right;
		int data;

		Node(int d) {
			data = d;
			left = right = null;
		}

	}

	// method1.=======================================================================

	private static Node prev = null;
	Node head = null;

	private void BT2DLL(Node root) {
		if (root != null) {
			BT2DLL(root.left);
			if (head == null) {
				head = root;
			} else {
				root.left = prev;
				prev.right = root;
			}
			prev = root;
			BT2DLL(root.right);
		}
	}
}
