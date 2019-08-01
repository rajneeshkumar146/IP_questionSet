package Tree;

public class Split_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// premium
	// https://leetcode.com/problems/split-bst/solution/

	public TreeNode[] splitBST(TreeNode root, int V) {
		if (root == null)
			return new TreeNode[] { null, null };
		else if (root.val <= V) {
			TreeNode[] bns = splitBST(root.right, V);
			root.right = bns[0];
			bns[0] = root;
			return bns;
		} else {
			TreeNode[] bns = splitBST(root.left, V);
			root.left = bns[1];
			bns[1] = root;
			return bns;
		}
	}
}
