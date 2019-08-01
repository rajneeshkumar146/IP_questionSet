package Tree;

public class Largest_BST_Subtree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int maxSize = 0;

	public int largestBSTSubtree(TreeNode root) {
		if (root == null)
			return 0;
		helper(root);
		return maxSize;
	}

	public SearchNode helper(TreeNode root) {
		if (root == null)
			return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);

		SearchNode left = helper(root.left);
		SearchNode right = helper(root.right);

		// current tree is NOT a BST
		if (left.size == -1 || right.size == -1 // either left or right subtree
												// is not BST
				|| root.val <= left.max || root.val >= right.min)
			return new SearchNode(-1, 0, 0);

		// current tree is a BST
		int curSize = left.size + right.size + 1;
		maxSize = Math.max(maxSize, curSize);
		return new SearchNode(curSize, Math.min(left.min, root.val), Math.max(right.max, root.val));
	}

	class SearchNode {
		int size; // -1 if not BST
		int min; // min value in the sub tree with cur node as root
		int max; // max value in the sub tree with cur node as root

		public SearchNode(int size, int min, int max) {
			this.size = size;
			this.min = min;
			this.max = max;
		}
	}
}
