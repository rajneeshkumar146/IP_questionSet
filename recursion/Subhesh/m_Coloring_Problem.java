package BackTracking;

import java.util.Scanner;

public class m_Coloring_Problem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int n = scn.nextInt();
			int[][] graph = new int[n][n];
			int m = scn.nextInt();
			int e = scn.nextInt();
			for (int i = 0; i < e; i++) {
				int e1 = scn.nextInt();
				int e2 = scn.nextInt();
				graph[e1 - 1][e2 - 1] = 1;
				graph[e2 - 1][e1 - 1] = 1;
			}
			int[] color = new int[graph.length];
			if (coloring(graph, m, color, 0) == false) {
				System.out.println(0);
			} else {
				System.out.print(1);
			}
		}
	}

	private static boolean coloring(int[][] graph, int m, int[] color, int cvtx) {
		if (cvtx == graph.length) {
			return true;
		}

		for (int i = 1; i <= m; i++) {
			if (issafe(graph, i, cvtx, color)) {
				color[cvtx] = i;
				boolean ans = coloring(graph, m, color, cvtx + 1);
				if (ans == true) {
					return true;
				}
				color[cvtx] = 0;
			}
		}
		return false;
	}

	private static boolean issafe(int[][] graph, int ccol, int cvtx, int[] color) {
		for (int i = 0; i < graph.length; i++) {
			if ((graph[cvtx][i] == 1) && (color[i] == ccol)) {
				return false;
			}
		}
		return true;
	}
}
