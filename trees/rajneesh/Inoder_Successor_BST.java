package Tree;

public class Inoder_Successor_BST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int succesor(TreeNode root, int x) {
		TreeNode succ = new TreeNode(0);
		inoderSucessor(root, succ, x);
		return succ.left.val;
	}

	public void inoderSucessor(TreeNode root, TreeNode succ, int x) {
		if (root == null)
			return;
		if (root.val == x) {
			if (root.right != null) {
				TreeNode nn = root.right;
				while (nn.left != null) {
					nn = nn.left;
				}

				succ.left = nn;
			}

		} else if (root.val < x) {
			succ.left = root;
			inoderSucessor(root.left, succ, x);
		} else if (root.val > x)
			inoderSucessor(root.right, succ, x);

	}

}
