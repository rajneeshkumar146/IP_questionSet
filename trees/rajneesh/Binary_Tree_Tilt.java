package Tree;

public class Binary_Tree_Tilt {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static class tilt {
		int sum = 0;
		int overallTilt = 0;

		public tilt(int sum, int overallTilt) {
			this.sum = sum;
			this.overallTilt = overallTilt;
		}
	}

	public static int findTilt(TreeNode node) {
		return TiltOfTree(node).overallTilt;
	}

	public static tilt TiltOfTree(TreeNode node) {
		if (node == null)
			return new tilt(0, 0);

		tilt left = TiltOfTree(node.left);
		tilt right = TiltOfTree(node.right);

		int CurrTilt = Math.abs(left.sum - right.sum);

		tilt ans = new tilt(left.sum + right.sum + node.val, left.overallTilt + right.overallTilt + CurrTilt);
		return ans;
	}

}
