package Tree;

public class Range_Sum_of_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null)
			return 0;

		if (R < root.val) {
			return rangeSumBST(root.left, L, R);
		} else if (L > root.val) {
			return rangeSumBST(root.right, L, R);
		} else {
			int res = root.val;
			res += rangeSumBST(root.left, L, R);
			res += rangeSumBST(root.right, L, R);
			return res;
		}

	}
}
