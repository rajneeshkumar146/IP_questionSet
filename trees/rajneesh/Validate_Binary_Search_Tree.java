package Tree;

public class Validate_Binary_Search_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;

		if (dfs(root))
			return true;

		return false;
	}

	int min;
	boolean firstTime = true;
	boolean isBFS = true;

	public boolean dfs(TreeNode node) { // InOder Traversal for validation of
										// BST.

		if (node.left != null)
			isBFS = dfs(node.left);
		if (firstTime || node.val > min) {
			min = node.val;
			firstTime = false;
		} else {
			return false;
		}
		if (node.right != null && isBFS)
			isBFS = dfs(node.right);

		return isBFS;
	}

}
