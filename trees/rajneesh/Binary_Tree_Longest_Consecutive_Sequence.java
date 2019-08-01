package Tree;

public class Binary_Tree_Longest_Consecutive_Sequence {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int longestConsecutive(TreeNode root) {
		return dfs(root, null, 0);
	}

	private int dfs(TreeNode p, TreeNode parent, int length) {
		if (p == null)
			return length;
		length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
		return Math.max(length, Math.max(dfs(p.left, p, length), dfs(p.right, p, length)));
	}
}
