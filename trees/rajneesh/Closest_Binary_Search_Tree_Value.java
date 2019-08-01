package Tree;

public class Closest_Binary_Search_Tree_Value {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int closestValue(TreeNode root, double target) {
		int res = root.val;
		while (root != null) {
			if (Math.abs(root.val - target) < Math.abs(res - target)) {
				res = root.val;
			}

			root = root.val > target ? root.left : root.right;
		}

		return res;
	}
}
