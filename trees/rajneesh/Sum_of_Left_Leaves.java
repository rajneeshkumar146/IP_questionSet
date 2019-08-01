package Tree;

public class Sum_of_Left_Leaves {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves_(root, false);
	}

	public int sumOfLeftLeaves_(TreeNode root, boolean isLeft) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null && isLeft)
			return root.val;
		return sumOfLeftLeaves_(root.left, true) + sumOfLeftLeaves_(root.right, false);
	}
}
