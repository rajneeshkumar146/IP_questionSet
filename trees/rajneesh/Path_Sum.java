package Tree;

public class Path_Sum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum - root.val == 0) {
			return true;
		}

		boolean res = false;
		res = res || hasPathSum(root.left, sum - root.val);
		res = res || hasPathSum(root.right, sum - root.val);
		return res;

	}

}
