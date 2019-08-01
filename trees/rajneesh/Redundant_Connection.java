package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Redundant_Connection {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Set<Integer> seen = new HashSet<>();

	public int[] findRedundantConnection(int[][] edges) {
		ArrayList<Integer>[] graph = new ArrayList[1001];
		for (int i = 0; i <= 1000; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] edge : edges) {
			seen.clear();
			if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() && dfs(graph, edge[0], edge[1])) {
				return edge;
			}
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		return new int[2];
	}

	public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
		if (!seen.contains(source)) {
			seen.add(source);
			if (source == target)
				return true;
			for (int nei : graph[source]) {
				if (dfs(graph, nei, target))
					return true;
			}
		}
		return false;
	}

}
