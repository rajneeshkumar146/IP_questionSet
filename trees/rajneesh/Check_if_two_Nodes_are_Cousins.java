package Tree;

public class Check_if_two_Nodes_are_Cousins {
	private static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int data) {
			this.val = data;
		}
	}

	// method1.========================================================================

	public boolean isCousins(TreeNode root, int x, int y) {
		pair px = new pair(x, 1, null);
		pair py = new pair(y, 1, null);

		return (isCousins_(root, null, px, py, 1) && px.par != py.par && px.level == py.level);

	}

	public static class pair {
		TreeNode par = null;
		int level = 0;
		int data = 0;

		pair(int data, int level, TreeNode par) {
			this.par = par;
			this.level = level;
			this.data = data;
		}

	}

	public boolean isCousins_(TreeNode root, TreeNode par, pair x, pair y, int level) {
		if (root == null)
			return false;

		if (root.val == x.data) {
			x.level = level;
			x.par = par;
		}

		if (root.val == y.data) {
			y.level = level;
			y.par = par;
		}

		if (x.par != null && y.par != null)
			return true;

		boolean res = false;
		res = res || isCousins_(root.left, root, x, y, level + 1);
		res = res || isCousins_(root.right, root, x, y, level + 1);
		return res;
	}

	// method2.=========================================================================

}
