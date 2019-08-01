package Tree;

public class Maximum_Difference_Between_Node_and_Ancestor {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxAncestorDiff(TreeNode root) {
		return maxancestor_(root, root.val, root.val);
	}

	public int maxancestor_(TreeNode root, int min, int max) {
		if (root == null)
			return max - min;
		max = Math.max(max, root.val);
		min = Math.min(min, root.val);
		return Math.max(maxancestor_(root.left, min, max), maxancestor_(root.right, min, max));
	}
}
