package Graph;

import java.util.LinkedList;
import java.util.Scanner;

public class Find_minimum_s_t_cut_in_a_flow_network {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t1 = scn.nextInt();
		for (int z = 0; z < t1; z++) {
			int n = scn.nextInt();

			int[][] graph = new int[n][n];
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[0].length; j++) {
					graph[i][j] = scn.nextInt();
				}
			}
			int s = scn.nextInt();
			int t = scn.nextInt();
			FordFulkerson(graph, s, t);
		}
	}

	private static void FordFulkerson(int[][] graph, int s, int t) {
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

		boolean[] visited = new boolean[graph.length];
		dfs(rgraph, s, visited);

		boolean flag = false;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if (graph[i][j] != 0 && visited[i] == true && visited[j] == false) {
					System.out.print(i + " " + j + " ");
					flag = true;
				}
			}
		}
		if (flag == false) {
			System.out.print("-1");
		}
		System.out.println();
	}

	private static void dfs(int[][] graph, int s, boolean[] visited) {
		visited[s] = true;
		for (int i = 0; i < graph.length; i++) {
			if (visited[i] == false && graph[s][i] != 0) {
				dfs(graph, i, visited);
			}
		}
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
