package Graph;

import java.util.LinkedList;

public class Matrix01 {

	public static void main(String[] args) {
		int[][] arr = new int[3][3];
		arr[1][1] = arr[2][0] = arr[2][1] = arr[2][2] = 1;

		int[][] ans = update(arr);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] update(int[][] matrix) {
		int[][] dist = new int[matrix.length][matrix[0].length];
		LinkedList<Pair> queue = new LinkedList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					dist[i][j] = Integer.MAX_VALUE;
				} else {
					queue.addLast(new Pair(i, j));
				}
			}
		}

		int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

		while (queue.size() != 0) {
			Pair pair = queue.removeFirst();
			for (int i = 0; i < dir.length; i++) {
				int nrow = pair.row + dir[i][0];
				int ncol = pair.col + dir[i][1];
				if (nrow >= 0 && nrow < matrix.length && ncol >= 0 && ncol < matrix[0].length) {
					if (dist[nrow][ncol] > dist[pair.row][pair.col] + 1) {
						dist[nrow][ncol] = dist[pair.row][pair.col] + 1;
						queue.addLast(new Pair(nrow, ncol));
					}
				}
			}
		}
		return dist;
	}

	private static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
