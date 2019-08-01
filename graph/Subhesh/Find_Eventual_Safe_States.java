package Graph;

import java.util.ArrayList;
import java.util.List;

public class Find_Eventual_Safe_States {

	public static void main(String[] args) {

	}

	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int N = graph.length;
		int[] color = new int[N];
		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < N; ++i)
			if (dfs(i, color, graph))
				ans.add(i);
		return ans;
	}

	// colors: WHITE 0, GRAY 1, BLACK 2;
	public static boolean dfs(int node, int[] color, int[][] graph) {
		if (color[node] > 0)
			return color[node] == 2;

		color[node] = 1;
		for (int nei : graph[node]) {
			if (color[node] == 2)
				continue;
			if (color[nei] == 1 || !dfs(nei, color, graph))
				return false;
		}
		color[node] = 2;
		return true;
	}
}
