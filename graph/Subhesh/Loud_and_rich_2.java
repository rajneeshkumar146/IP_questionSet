package Graph;

import java.util.ArrayList;

public class Loud_and_rich_2 {

	public static void main(String[] args) {
		int[][] richer = { { 0, 1 } };
		int[] quiet = { 0, 1 };
		int[] ans = loudAndRich(richer, quiet);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	private static int[] loudAndRich(int[][] richer, int[] quiet) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < quiet.length; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < richer.length; i++) {
			int v1 = richer[i][0];
			int v2 = richer[i][1];

			graph.get(v2).add(v1);
		}
		int[] ans = new int[quiet.length];
		boolean[] visited = new boolean[quiet.length];

		for (int i = 0; i < quiet.length; i++) {
			if (visited[i] == false) {
				dfs(graph, visited, quiet, i, ans);
			}
		}
		return ans;
	}

	private static int dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int[] quiet, int src, int[] ans) {

		if (visited[src] == false) {
			visited[src] = true;
			ans[src] = src;
			for (int nbr : graph.get(src)) {
				int bidx = dfs(graph, visited, quiet, nbr, ans);
				if (quiet[bidx] < quiet[ans[src]]) {
					ans[src] = bidx;
				}
			}
		}
		return ans[src];
	}
}
