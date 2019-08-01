package Tree;

public class Flip_Equivalent_Binary_Trees {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * If at least one of the two root nodes is null, are they equal? if yes,
	 * true; if no, false; otherwise, neither node is null; if the values of the
	 * two nodes are: 2a) NOT equal, return false; 2b) equal, compare their
	 * children recursively.
	 */
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == root2)
			return true;
		if (root1 == null || root2 == null || root1.val != root2.val)
			return false;

		return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
				|| flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
	}

}
