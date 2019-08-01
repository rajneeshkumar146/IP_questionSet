package Tree;

import Tree.pth_common_ancestor_in_BST.Node;

public class Max_and_min_element_in_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int findMax(Node root) {
		if (root == null)
			return Integer.MIN_VALUE;
		if (root.left == null && root.right == null)
			return root.data;
		return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
	}

	public static int findMin(Node root) {

		if (root == null)
			return Integer.MAX_VALUE;
		if (root.left == null && root.right == null)
			return root.data;
		return Math.min(root.data, Math.min(findMin(root.left), findMin(root.right)));
	}

}
