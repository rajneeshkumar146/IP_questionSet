package Tree;

public class Binary_Search_Tree_to_Greater_Sum_Tree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int sum = 0;

	public TreeNode bstToGst(TreeNode root) {

		sum = 0;
		bstToGst_(root);
		return root;
	}

	public void bstToGst_(TreeNode root) {
		if (root == null)
			return;
		bstToGst_(root.right);
		sum += root.val;
		root.val = sum;
		bstToGst_(root.left);

	}

}
