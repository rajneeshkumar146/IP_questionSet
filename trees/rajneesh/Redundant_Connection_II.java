package Tree;

public class Redundant_Connection_II {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * There are two cases for the redundant connection: The edge connect from a
	 * child node to root, so there will be a loop. In this case we just need to
	 * remove the edge that will cause loop in the graph. (cases like [1, 2],
	 * [1, 3], [2, 1]) The edge connect from one child node to another child
	 * node, so there will be one node which has two parents The 2-parents case
	 * can be further specified to two cases: with loop, or without loop. For
	 * without loop cases, we just need to remove the later appeared one (cases
	 * like [1, 2], [1, 3], [2, 3]) For the with loop case, we need to remove
	 * the one in the loop (cases like [5, 2], [1, 2], [2, 3], [4, 5], [3, 4])
	 * so we use an array to store the parent of each node, and check if any
	 * node have two parents. if there is, then those two edges are the possible
	 * answer. use union find to check by removing one of those edge, if the
	 * remain edges formed a valid tree or not. if is a valid tree, return that
	 * edge, else return the other edge. if there’s no node with two in parent,
	 * then return the edge that will cause the loop in the graph.
	 */

	public int[] findRedundantDirectedConnection(int[][] edges) {
		int m = edges.length;
		int[] parent = new int[m + 1];
		int[] res1 = new int[2];
		int[] res2 = new int[2];
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			if (parent[to] == 0) {
				parent[to] = from;
			} else {
				res2 = new int[] { from, to };
				res1 = new int[] { parent[to], to };
				break;
			}
		}
		parent = new int[m + 1];
		for (int i = 1; i <= m; i++) {
			parent[i] = i;
		}
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			if (from == res2[0] && to == res2[1])
				continue;
			int r1 = findRoot(from, parent);
			int r2 = findRoot(to, parent);
			if (r1 == r2) { // from and to has already been connect to the same
							// root
				if (res1[0] == 0)
					return new int[] { from, to };
				else
					return res1;
			}
			parent[to] = from;
		}
		return res2;
	}

	private int findRoot(int v, int[] parent) {
		while (v != parent[v]) {
			parent[v] = parent[parent[v]];
			v = parent[v];
		}
		return v;
	}
}
