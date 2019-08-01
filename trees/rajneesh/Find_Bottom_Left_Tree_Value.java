package Tree;

public class Find_Bottom_Left_Tree_Value {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int findBottomLeftValue(TreeNode root) {
		TreeNode pair = new TreeNode(0);
		findBottomLeftValue_(root, pair, 0, true);
		return pair.left.val;
	}

	// aceptable solution.
	public static void findBottomLeftValue_(TreeNode root, TreeNode pair, int level) {
		if (root == null)
			return;

		findBottomLeftValue_(root.left, pair, level + 1);
		findBottomLeftValue_(root.right, pair, level + 1);

		if (root.left == null && root.right == null && level > pair.val) {
			pair.left = root;
			pair.val = level;
		}

	}

	// not accepted.
	public static void findBottomLeftValue_(TreeNode root, TreeNode pair, int level, boolean isLeft) {
		if (root == null)
			return;

		findBottomLeftValue_(root.left, pair, level + 1, true);
		findBottomLeftValue_(root.right, pair, level + 1, false);

		if (isLeft && root.left == null && root.right == null && level > pair.val) {
			pair.left = root;
			pair.val = level;
		}

	}

	// 0 null -1
	// -1

}
