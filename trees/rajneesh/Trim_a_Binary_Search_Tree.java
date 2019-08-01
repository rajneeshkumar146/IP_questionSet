package Tree;

public class Trim_a_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {

		if (root == null)
			return null;

		if (root.val < L) {
			return trimBST(root.right, L, R);
		} else if (root.val > R) {
			return trimBST(root.left, L, R);
		} else {
			TreeNode left = trimBST(root.left, L, R);
			TreeNode right = trimBST(root.right, L, R);

			root.left = left;
			root.right = right;
			return root;
		}
	}

}
