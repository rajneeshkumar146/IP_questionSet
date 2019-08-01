package HnH;

import java.util.LinkedList;

public class Cheaest_Flights_Within_K_Stops {

	public static void main(String[] args) {
		int n = 3;
		int[][] graph = new int[n][n];
		graph[0][1] = 100;
		graph[1][2] = 100;
		graph[0][2] = 500;
		int src = 0;
		int dest = 2;
		int k = 1;
		findCheapestPrice(n, graph, src, dest, k + 1);
		System.out.println(ans);
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[][] arr = new int[n][n];
		for (int i = 0; i < flights.length; i++) {
			int v1 = flights[i][0];
			int v2 = flights[i][1];
			int wt = flights[i][2];
			arr[v1][v2] = wt;
		}
		K++;
		boolean[] visited = new boolean[n];
		ans = Integer.MAX_VALUE;
		dfs(arr, src, dst, K, visited, 0);
		if (ans == Integer.MAX_VALUE) {
			return -1;
		} else {
			return ans;
		}
	}

	static int ans;

	private static void dfs(int[][] flights, int src, int dest, int k, boolean[] visited, int csf) {
		if (k < 0) {
			return;
		}
		if (csf > ans) {
			return;
		}
		if (src == dest) {
			if (k >= 0) {
				ans = Math.min(ans, csf);
			}
			return;
		}
		visited[src] = true;
		for (int i = 0; i < flights.length; i++) {
			if (visited[i] == false && flights[src][i] != 0) {
				dfs(flights, i, dest, k - 1, visited, csf + flights[src][i]);
			}
		}
		visited[src] = false;
	}
}
