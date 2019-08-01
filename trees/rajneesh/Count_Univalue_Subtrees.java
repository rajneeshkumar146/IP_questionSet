package Tree;

public class Count_Univalue_Subtrees {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;
		isUniValue(root);
		return count;
	}

	int count = 0;

	public boolean isUniValue(TreeNode node) {
		if (node.left == null && node.right == null) {
			this.count++;
			return true;
		}

		boolean isUni = true;

		if (node.left != null) {
			isUni = isUniValue(node.left) && isUni && node.val == node.left.val;
		}

		if (node.right != null) {
			isUni = isUniValue(node.right) && isUni && node.val == node.right.val;
		}

		if (!isUni)
			return false;
		count++;
		return true;

	}

}
