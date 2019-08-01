package Tree;

import java.util.LinkedList;

public class Deletion_in_a_Binary_Tree {
	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node deletionBT(Node root, int key) {
		// Write your code here and return the root of the changed tree
		if (root == null)
			return root;

		LinkedList<Node> que = new LinkedList<>();
		que.addLast(root);

		Node node = null;
		Node suspect = null;
		while (!que.isEmpty()) {
			node = que.removeFirst();

			if (node.data == key)
				suspect = node;

			if (node.left != null)
				que.addLast(node.left);
			if (node.right != null)
				que.addLast(node.right);
		}

		if (suspect != null) {
			deleteDeepest(root, node);
			suspect.data = node.data;
		}
		return root;
	}

	private static void deleteDeepest(Node root, Node key) {
		LinkedList<Node> que = new LinkedList<>();
		que.addLast(root);

		Node node = null;
		while (!que.isEmpty()) {
			node = que.removeFirst();

			if (node.left != null) {
				if (node.left == key) {
					node.left = null;
					return;
				}
				que.addLast(node.left);
			}

			if (node.right != null) {
				if (node.right == key) {
					node.right = null;
					return;
				}
				que.addLast(node.right);
			}

		}
	}
}
