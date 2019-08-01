package Tree;

public class Check_for_Balanced_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		return isBal(root).isbal;
	}

	private static class pair {
		boolean isbal = true;
		int height = 0;

		pair(boolean isbal, int height) {
			this.isbal = isbal;
			this.height = height;
		}
	}

	public pair isBal(TreeNode root) {
		if (root == null)
			return new pair(true, -1);

		pair le = isBal(root.left);
		pair ri = isBal(root.right);

		if (!le.isbal || !ri.isbal || Math.abs(le.height - ri.height) > 1)
			return new pair(false, -1);

		return new pair(true, Math.max(le.height, ri.height) + 1);

	}
}
