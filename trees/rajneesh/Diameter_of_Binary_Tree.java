package Tree;

public class Diameter_of_Binary_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static int dia = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		dia = 0;
		diameterOfBinaryTree_(root);
		return dia;
	}

	public int diameterOfBinaryTree_(TreeNode root) {
		if (root == null)
			return -1;
		int lh = diameterOfBinaryTree_(root.left);
		int rh = diameterOfBinaryTree_(root.right);
		dia = Math.max(dia, lh + rh + 2);
		return Math.max(lh, rh) + 1;
	}

}
