package Tree;

public class Binary_Tree_Pruning {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode pruneTree(TreeNode root) {
		if (root == null)
			return null;

		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);

		if (root.left == null && root.right == null && root.val == 0)
			return null;
		return root;
	}

}
