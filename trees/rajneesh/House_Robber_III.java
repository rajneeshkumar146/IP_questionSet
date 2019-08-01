package Tree;

public class House_Robber_III {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rob(TreeNode root) {
		int[] maxVal = dpRob(root);
		return Math.max(maxVal[0], maxVal[1]);
	}

	public int[] dpRob(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 };
		} else {
			int[] maxVal = new int[2];// maxVal[0] store the max value without
										// robing current node, maxVal[1] store
										// the max value with robing current
										// node,
			int[] leftMax = dpRob(root.left);
			int[] rightMax = dpRob(root.right);
			maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
			maxVal[1] = leftMax[0] + rightMax[0] + root.val;
			return maxVal;
		}
	}
}
