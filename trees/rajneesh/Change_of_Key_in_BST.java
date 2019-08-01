package Tree;

public class Change_of_Key_in_BST {
	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	Node changeKey(Node root, int old_key, int new_key) {
		Node node = delete(root, old_key);
		return insert(root, new_key);
	}

	static Node insert(Node node, int key) {
		if (node == null)
			return new Node(key);

		if (key < node.data)
			node.left = insert(node.left, key);
		else
			node.right = insert(node.right, key);

		return node;
	}

	Node delete(Node node, int data) {
		if (node == null)
			return null;

		if (node.data < data) {
			node.right = delete(node.right, data);
		} else if (node.data > data) {
			node.left = delete(node.left, data);
		} else {
			if (node.left == null && node.right == null)
				return null;
			if (node.left == null || node.right == null)
				return (node.left != null ? node.left : node.right);

			int small = smallest(node.right);
			node.data = small;
			node.right = delete(node.right, small);
		}
		return node;

	}

	int smallest(Node node) {
		Node n = node;
		while (n.left != null) {
			n = n.left;
		}
		return n.data;
	}
}
