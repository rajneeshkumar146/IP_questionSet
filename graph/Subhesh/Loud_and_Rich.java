package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Loud_and_Rich {

	public static void main(String[] args) {
		int[][] richer = { { 0, 1 } };
		int[] quiet = { 0,1 };
		int[] ans = loudAndRich(richer, quiet);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	static ArrayList<Integer>[] graph;
	static int[] answer;
	static int[] quiet;

	public static int[] loudAndRich(int[][] richer, int[] quiet1) {
		int N = quiet1.length;
		graph = new ArrayList[N];
		answer = new int[N];
		quiet = quiet1;
		for (int node = 0; node < N; ++node)
			graph[node] = new ArrayList<Integer>();

		for (int[] edge : richer)
			graph[edge[1]].add(edge[0]);

		Arrays.fill(answer, -1);

		for (int node = 0; node < N; ++node)
			dfs(node);
		return answer;
	}

	public static int dfs(int node) {
		if (answer[node] == -1) {
			answer[node] = node;
			for (int child : graph[node]) {
				int cand = dfs(child);
				if (quiet[cand] < quiet[answer[node]])
					answer[node] = cand;
			}
		}
		return answer[node];
	}
}
