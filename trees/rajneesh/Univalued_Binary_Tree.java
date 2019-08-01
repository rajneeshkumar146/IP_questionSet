package Tree;

public class Univalued_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	boolean firstRun = true;
	int val;
	boolean change = false;

	public boolean isUnivalTree(TreeNode root) {
		if (root == null)
			return true;
		if (firstRun) {
			val = root.val;
			firstRun = false;
		} else {
			if (val != root.val) {
				change = true;
			}
		}

		if (change)
			return false;

		return isUnivalTree(root.left) && isUnivalTree(root.right);

	}
}
