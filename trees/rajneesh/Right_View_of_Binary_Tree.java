package Tree;

public class Right_View_of_Binary_Tree {
	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			data = x;
		}
	}

	void rightView(TreeNode root) {
		rightSideView_(root, 0, new TreeNode(-1));

	}

	public static void rightSideView_(TreeNode root, int level, TreeNode node) {
		if (root == null)
			return;

		if (level > node.data) {
			System.out.print(root.data + " ");
			node.data = level;
		}
		rightSideView_(root.right, level + 1, node);
		rightSideView_(root.left, level + 1, node);

	}
}
