package Tree;

public class Delete_Node_in_a_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode deleteNode(TreeNode node, int key) {
		if (node == null)
			return node;
		if (node.val < key)
			node.right = deleteNode(node.right, key);
		else if (node.val > key)
			node.left = deleteNode(node.left, key);
		else {

			if (node.left == null && node.right == null)
				return null;
			if (node.right == null || node.left == null)
				return node.left != null ? node.left : node.right;

			TreeNode temp = findDeleteReplaceRight(node);
			node.val = temp.val;
			node.right = deleteNode(node.right, temp.val);
		}
		return node;

	}

	public TreeNode findDeleteReplaceRight(TreeNode root) {
		TreeNode right = root.right;
		while (right.left != null)
			right = right.left;
		return right;
	}

}
