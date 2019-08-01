package Tree;

public class Flatten_Binary_Tree_to_Linked_List {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		root = flatten_(root);
	}

	public TreeNode flatten_(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;

		TreeNode lastNodeOfRightSubTree = flatten_(root.right);
		TreeNode lastNodeOfLeftSubTree = flatten_(root.left);
		if (lastNodeOfLeftSubTree != null) {
			lastNodeOfLeftSubTree.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		return lastNodeOfRightSubTree != null ? lastNodeOfRightSubTree : lastNodeOfLeftSubTree;

	}

}
