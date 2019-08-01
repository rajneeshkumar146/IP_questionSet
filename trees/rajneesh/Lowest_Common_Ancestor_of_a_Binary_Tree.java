package Tree;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// assumptions both nodes are present.================================
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left == null && right == null)
			return null;
		return left == null ? right : right == null ? left : root;
	}

	// method2.============================================================

	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode node = new TreeNode(0);
		lowestCommonAncestor2(root, p, q, node);
		return node.left;
	}

	public static boolean lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q, TreeNode node) {
		if (root == null)
			return false;

		boolean selfDone = (root == p) || (root == q);

		boolean left = lowestCommonAncestor2(root.left, p, q, node);
		if (node.left != null)
			return true;

		boolean right = lowestCommonAncestor2(root.right, p, q, node);
		if (node.left != null)
			return true;

		if ((left && right) || (left && selfDone) || (right && selfDone)) {
			node.left = root;
		}

		return selfDone || left || right;
	}

}
