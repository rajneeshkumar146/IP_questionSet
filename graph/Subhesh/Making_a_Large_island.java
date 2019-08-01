package Graph;

import java.util.HashMap;

public class Making_a_Large_island {

	static void DFS(int i, int j, int[][] matrix, boolean visited[][], int id) {
		visited[i][j] = true;
		hm.put("" + i + j, id);
		counter++;

		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, };

		for (int[] x : dirs) {
			int newx = i + x[0];
			int newy = j + x[1];

			if (newx >= 0 && newx < matrix.length && newy >= 0 && newy < matrix[0].length
					&& visited[newx][newy] == false && matrix[newx][newy] == 1) {
				DFS(newx, newy, matrix, visited, id);
			}
		}
	}

	private int Check(int i, int j, int[][] matrix) {
		HashMap<Integer, Boolean> local = new HashMap<>();
		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, };
		int maxarea = 0;
		for (int[] x : dirs) {
			int newx = i + x[0];
			int newy = j + x[1];

			if (newx >= 0 && newx < matrix.length && newy >= 0 && newy < matrix[0].length && matrix[newx][newy] == 1) {
				int id = hm.get("" + newx + newy);
				if (!local.containsKey(id)) {
					local.put(id, true);
					maxarea = maxarea + area.get(id);
				}
			}
		}

		return maxarea + 1;
	}

	static int counter;
	static HashMap<String, Integer> hm;
	static HashMap<Integer, Integer> area;

	public int largestIsland(int[][] matrix) {

		boolean visited[][] = new boolean[matrix.length][matrix[0].length];
		int ans = 0;
		int id = 1;
		hm = new HashMap<>();
		area = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (visited[i][j] == false && matrix[i][j] == 1) {
					counter = 0;
					DFS(i, j, matrix, visited, id);
					area.put(id, counter);
					ans = Math.max(ans, counter);
					id++;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					ans = Math.max(ans, Check(i, j, matrix));
				}
			}
		}

		return ans;
	}
}
