package Tree;

public class Binary_Tree_Maximum_Path_Sum {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxPathSum(TreeNode root) {

		pair p = new pair(Integer.MIN_VALUE);

		int ans = MaxPathSum(root, p);
		return p.res;

	}

	static class pair {
		int res = 0;

		public pair(int res) {
			this.res = res;
		}
	}

	public static int MaxPathSum(TreeNode node, pair p) {
		if (node == null)
			return 0;

		if (node.left == null && node.right == null) {
			p.res = Math.max(p.res, node.val);
			return node.val;
		}

		int left = MaxPathSum(node.left, p);
		int right = MaxPathSum(node.right, p);

		int max = Math.max(left, right);

		if (node.left != null && node.right != null) {
			p.res = Math.max(Math.max(left + right + node.val, p.res), Math.max(max + node.val, node.val));

			return Math.max(max + node.val, node.val);
		}

		int rVal = Math.max((node.left != null ? left : right) + node.val, node.val);
		p.res = Math.max(rVal, p.res);
		return rVal;
	}

}
