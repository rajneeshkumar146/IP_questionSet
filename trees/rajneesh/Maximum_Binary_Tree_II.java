package Tree;

public class Maximum_Binary_Tree_II {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode insertIntoMaxTree(TreeNode root, int v) {
		if (root == null)
			return new TreeNode(v);
		if (root.val < v) {
			TreeNode node = new TreeNode(v);
			node.left = root;
			return node;
		}
		root.right = insertIntoMaxTree(root.right, v);
		return root;
	}

}
