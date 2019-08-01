package Tree;

import Tree.Vertical_Order_Traversal_of_a_Binary_Tree.TreeNode;

public class Search_in_a_Binary_Search_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode searchBST(TreeNode root, int val) {
		while (root != null) {
			if (root.val > val)
				root = root.left;
			else if (root.val < val)
				root = root.right;
			else if (root.val == val)
				return root;
		}
		return null;

	}

}
