package Tree;

import javax.swing.tree.TreeNode;

public class Size_of_Binary_Tree {

	private static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static int size(Node root) {
		if (root == null)
			return 0;

		return size(root.left) + size(root.right) + 1;
	}
}
