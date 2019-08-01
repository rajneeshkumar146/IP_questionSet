package Tree;

public class Minimum_Absolute_Difference_in_BST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static int min = -1;
	static int ans = -1;

	public int getMinimumDifference(TreeNode root) {
		ans = 1000000;
		min = -1;
		minDiffInBST_(root);
		return ans;
	}

	public static void minDiffInBST_(TreeNode root) {
		if (root == null) {
			return;
		}

		minDiffInBST_(root.left);

		if (min == -1) {
			min = root.val;
		} else {
			ans = Math.min(ans, root.val - min);
			min = root.val;
		}

		minDiffInBST_(root.right);
	}

}
