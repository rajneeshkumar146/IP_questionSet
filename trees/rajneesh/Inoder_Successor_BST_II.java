package Tree;

public class Inoder_Successor_BST_II {

	/*
	 * Given a binary search tree and a node in it, find the in-order successor
	 * of that node in the BST.
	 * 
	 * The successor of a node p is the node with the smallest key greater than
	 * p.val.
	 * 
	 * You will have direct access to the node but not to the root of the tree.
	 * Each node will have a reference to its parent node.
	 */

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int x) {
			val = x;
		}
	}

	// method1=========================================================

	public TreeNode inorderSuccessor(TreeNode x) {

		if (x == null) {
			return null;
		} else if (x.right != null) {
			x = x.right;
			while (x.left != null) {
				x = x.left;
			}
			return x;
		} else {
			TreeNode res = x.parent;
			while (res != null && res.val < x.val) {
				res = res.parent;
			}
			return res;
		}

	}

	// method2============================================================

	public TreeNode inorderSuccessor2(TreeNode x) {

		if (x == null) {
			return null;
		} else if (x.right != null) {
			x = x.right;
			while (x.left != null) {
				x = x.left;
			}
			return x;
		} else {
			while (x != null && x.parent != null && x.parent.left != x) {
				x = x.parent;
			}
			return x.parent;

		}

	}

	// https://www.cnblogs.com/grandyang/p/10424982.html

}
