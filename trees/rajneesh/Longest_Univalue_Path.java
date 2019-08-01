package Tree;

public class Longest_Univalue_Path {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int max = 0;

	public int longestUnivaluePath(TreeNode root) {
		max = 0;

		// longestUnivalue(root);
		longestUnivalue_02(root);

		return max;
	}

	// Method_01.=======================================================================
	// O(n2).
	public void longestUnivalue(TreeNode root) {
		if (root == null)
			return;

		int count = Longestpath(root.left, root.val) + Longestpath(root.right, root.val);
		if (count > max) {
			max = count;
		}
		longestUnivalue(root.left);
		longestUnivalue(root.right);
	}

	public static int Longestpath(TreeNode node, int rootValue) {
		int count = 0;
		if (node != null && node.val == rootValue) {
			int left = Longestpath(node.left, rootValue);
			int right = Longestpath(node.right, rootValue);
			count = Math.max(left, right) + 1;
		}
		return count;
	}

	// Method_02.=======================================================================
	// O(n).

	public int longestUnivalue_02(TreeNode root) {
		if (root == null)
			return 0;

		int left = longestUnivalue_02(root.left);
		int right = longestUnivalue_02(root.right);

		if (root.left != null && root.left.val == root.val)
			left++;
		if (root.right != null && root.right.val == root.val)
			right++;

		max = Math.max(max, left + right);
		return Math.max(left, right);
	}

}
