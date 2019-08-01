package Tree;

public class Increasing_Order_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// method1.====================================================================

	public TreeNode increasingBST(TreeNode root) {
		if (root == null)
			return null;

		if (root.left == null) {
			root.right = increasingBST(root.right);
			return root;
		}

		TreeNode leftNode = increasingBST(root.left);
		TreeNode temp = leftNode;
		while (temp != null && temp.right != null) {
			temp = temp.right;
		}

		temp.right = root;
		root.left = null;

		root.right = increasingBST(root.right);
		return leftNode;
	}

	// method2.====================================================================
	static TreeNode curr; // help in traversing

	public TreeNode increasingBST_02(TreeNode root) {
		TreeNode result = new TreeNode(0);
		curr = result;
		increasingBST02_(root);
		return result.right;
	}

	public void increasingBST02_(TreeNode root) {
		if (root == null)
			return;
		increasingBST02_(root.left);

		root.left = null;
		curr.right = root; // storing value.
		curr = curr.right; // traversing node;

		increasingBST02_(root.right);

	}

}
