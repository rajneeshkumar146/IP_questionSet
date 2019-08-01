package Tree;

public class Root_to_leaf_paths_sum {
	private static class Tree {
		int data;
		Tree left, right;

		Tree(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	public static int treePathsSum(Tree node) {
		return treePathsSum_(node, 0);

	}

	public static int treePathsSum_(Tree node, int sum) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return sum * 10 + node.data;
		}

		int ans = 0;
		ans += treePathsSum_(node.left, sum * 10 + node.data);
		ans += treePathsSum_(node.right, sum * 10 + node.data);
		return ans;
	}

}
