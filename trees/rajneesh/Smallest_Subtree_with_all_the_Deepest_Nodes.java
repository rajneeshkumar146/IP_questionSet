package Tree;

public class Smallest_Subtree_with_all_the_Deepest_Nodes {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		return dfs(root).node;
	}

	// Return the result of the subtree at this node.
	public Result dfs(TreeNode node) {
		if (node == null)
			return new Result(null, 0);
		Result L = dfs(node.left), R = dfs(node.right);
		if (L.dist > R.dist)
			return new Result(L.node, L.dist + 1);
		if (L.dist < R.dist)
			return new Result(R.node, R.dist + 1);
		return new Result(node, L.dist + 1);
	}

	class Result {
		TreeNode node;
		int dist;

		Result(TreeNode n, int d) {
			node = n;
			dist = d;
		}
	}
}
