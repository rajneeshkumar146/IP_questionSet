package BackTracking;

import java.util.Scanner;

public class Path_Of_greater_than_equal_to_k_length {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int v = scn.nextInt();
			int e = scn.nextInt();
			int k = scn.nextInt();
			int[][] arr = new int[v][v];
			for (int i = 0; i < e; i++) {
				int a1 = scn.nextInt();
				int a2 = scn.nextInt();
				int a3 = scn.nextInt();
				arr[a1][a2] = a3;
				arr[a2][a1] = a3;
			}
			ans = 0;
			Pathgreater(arr, k, 0, 0, new boolean[arr.length]);
			System.out.println(ans);
		}
	}

	static int ans;

	private static void Pathgreater(int[][] arr, int k, int steps, int src, boolean[] visited) {
		if (steps >= k) {
			ans = 1;
			return;
		}
		visited[src] = true;
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == false && arr[src][i] != 0) {
				Pathgreater(arr, k, steps + arr[src][i], i, visited);

			}
		}
		visited[src] = false;
	}
}
