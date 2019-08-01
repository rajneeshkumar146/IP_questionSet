package Tree;

public class Count_Complete_Tree_Nodes {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// method_01===========================================================================
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	// method_02============================================================================

	// A better idea is to get the height of the left-most part, and height of
	// the right-most part. If the left height and right height are the same,
	// means the tree is full. Then the number of nodes is 2^h - 1. If not, we
	// recursively count the number of nodes for the left sub-tree and right
	// sub-tree.

	public int countNodes_02(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = findLeftHeight(root);
		int rightHeight = findRightHeight(root);

		if (leftHeight == rightHeight) {
			return (2 << (leftHeight - 1)) - 1;
		}

		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	private int findLeftHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int height = 1;

		while (root.left != null) {
			height++;
			root = root.left;
		}

		return height;
	}

	private int findRightHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int height = 1;

		while (root.right != null) {
			height++;
			root = root.right;
		}

		return height;
	}
}
