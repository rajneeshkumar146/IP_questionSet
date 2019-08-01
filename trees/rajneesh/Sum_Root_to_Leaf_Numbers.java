package Tree;

public class Sum_Root_to_Leaf_Numbers {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode node) {
		return treePathsSum_(node, 0);

	}

	public static int treePathsSum_(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return sum * 10 + node.val;
		}

		int ans = 0;
		ans += treePathsSum_(node.left, sum * 10 + node.val);
		ans += treePathsSum_(node.right, sum * 10 + node.val);

		return ans;
	}
}
