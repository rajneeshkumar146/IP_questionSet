package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class Find_the_Maximum_Flow {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			int m = scn.nextInt();

			int[][] graph = new int[n][n];
			for (int i = 0; i < m; i++) {
				int s1 = scn.nextInt();
				int s2 = scn.nextInt();
				int wt = scn.nextInt();
				graph[s1 - 1][s2 - 1] += wt;
				graph[s2 - 1][s1 - 1] += wt;
			}
			System.out.println(FordFulkerson(graph, 0, graph.length - 1));
		}
	}

	private static int FordFulkerson(int[][] graph, int s, int t) {
		int[][] rgraph = new int[graph.length][graph[0].length];
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				rgraph[i][j] = graph[i][j];
			}
		}
		int[] parent = new int[graph.length];
		int flow = 0;

		while (bfs(rgraph, s, t, parent)) {
			int mincap = Integer.MAX_VALUE;

			for (int i = t; i != s; i = parent[i]) {
				mincap = Math.min(mincap, rgraph[parent[i]][i]);
			}

			for (int i = t; i != s; i = parent[i]) {
				rgraph[parent[i]][i] -= mincap;
				rgraph[i][parent[i]] += mincap;
			}
			flow += mincap;
		}
		return flow;
	}

	private static boolean bfs(int[][] graph, int s, int t, int[] parent) {
		boolean[] visited = new boolean[graph.length];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(s);
		parent[s] = -1;
		visited[s] = true;

		while (queue.size() != 0) {
			int rem = queue.removeFirst();

			for (int i = 0; i < graph.length; i++) {
				if (visited[i] == false && graph[rem][i] != 0) {
					queue.addLast(i);
					parent[i] = rem;
					visited[i] = true;
				}
			}
		}
		return visited[t];
	}
}
