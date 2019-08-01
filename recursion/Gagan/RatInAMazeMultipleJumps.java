package recursion;

import java.util.Scanner;

class RatMazeMultipleJumps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int[][] path = new int[n][n];
		if (isPath(matrix, path, 0, 0, n) == -1) {
			System.out.println(-1);
		}
	}

	private static int isPath(int[][] matrix, int[][] path, int cr, int cc, int n) {
		if (cr < 0 || cc < 0 || cr >= n || cc >= n) {
			return -1;
		}
		if (cr == n - 1 && cc == n - 1) {
			path[cr][cc] = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(path[i][j] + " ");
				}
				System.out.println();
			}
			path[cr][cc] = 0;
			return 1;
		}
		if (matrix[cr][cc] == 0 || path[cr][cc] == 1) {
			return -1;
		}
		path[cr][cc] = 1;
		int val = matrix[cr][cc];
		for (int i = 1; i <= val; i++) {
			if (isPath(matrix, path, cr, cc + i, n) == 1) {
				return 1;
			}
			if (isPath(matrix, path, cr + i, cc, n) == 1) {
				return 1;
			}
		}
		path[cr][cc] = 0;
		return -1;
	}

}