package misc;

import java.util.Scanner;

public class hopscotch {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int m = scn.nextInt();

			int[][] mat = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					mat[i][j] = scn.nextInt();
				}
			}

			int player = scn.nextInt();
			int row = scn.nextInt();
			int col = scn.nextInt();

			int res = 0;
			if (player == 0) {
				res = calcPlayer0(mat, row, col);
			} else {
				res = calcPlayer1(mat, row, col);
			}
			System.out.println(res);
		}
	}

	public static boolean isValid(int[][] mat, int i, int j) {
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
			return false;
		}
		return true;
	}

	public static int calcPlayer0(int[][] mat, int row, int col) {
		int res = 0;
		int[] rdir = { -1, 0, 1, 0 };
		int[] cdir = { 0, -1, 0, 1 };

		for (int i = 0; i < 4; i++) {
			int ridx = row + rdir[i];
			int cidx = col + cdir[i];
			if (isValid(mat, ridx, cidx)) {
				res += mat[ridx][cidx];
			}
		}
		if (col % 2 == 0) {
			if (isValid(mat, row - 1, col - 1)) {
				res += mat[row - 1][col - 1];
			}
			if (isValid(mat, row - 1, col + 1)) {
				res += mat[row - 1][col + 1];
			}
		} else {
			if (isValid(mat, row + 1, col - 1)) {
				res += mat[row + 1][col - 1];
			}
			if (isValid(mat, row + 1, col + 1)) {
				res += mat[row + 1][col + 1];
			}

		}
		return res;
	}

	public static int calcPlayer1(int[][] mat, int row, int col) {
		int res = 0;
		int[] rdir = { -1, -2, -2, -2, -1, 0, 1, 1, 2, 1, 1, 0 };
		int[] cdir = { 2, 1, 0, -1, -2, 2, 2, 1, 0, -1, -2, -2 };

		if (col % 2 == 0) {
			for (int i = 0; i < rdir.length; i++) {
				int ridx = row + rdir[i];
				int cidx = col + cdir[i];
				if (isValid(mat, ridx, cidx)) {
					res += mat[ridx][cidx];
				}
			}
		} else {
			for (int i = 0; i < rdir.length; i++) {
				rdir[i] *= -1;
				cdir[i] *= -1;
			}
			for (int i = 0; i < rdir.length; i++) {
				int ridx = row + rdir[i];
				int cidx = col + cdir[i];
				if (isValid(mat, ridx, cidx)) {
					res += mat[ridx][cidx];
				}
			}
		}
		return res;
	}

}
