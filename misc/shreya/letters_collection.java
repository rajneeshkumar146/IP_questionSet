package misc;

import java.util.Scanner;

public class letters_collection {
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
			int q = scn.nextInt();
			int[] qres = new int[q];
			for (int i = 0; i < q; i++) {
				int step = scn.nextInt();
				int row = scn.nextInt();
				int col = scn.nextInt();
				if (step == 1)
					qres[i] = calculateLetters1(mat, row, col);
				else
					qres[i] = calculateLetters2(mat, row, col);

			}
			for (int i = 0; i < q; i++) {
				System.out.println(qres[i]);
			}

		}
	}

	public static boolean isValid(int[][] mat, int i, int j) {
		if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length) {
			return false;
		}
		return true;
	}

	public static int calculateLetters1(int[][] mat, int row, int col) {
		int res = 0;
		int[] rdir = { 1, 1, 1, 0, 0, -1, -1, -1 };
		int[] cdir = { -1, 0, 1, -1, 1, -1, 0, +1 };

		for (int i = 0; i < rdir.length; i++) {
			int ridx = rdir[i] + row;
			int cidx = cdir[i] + col;
			if (isValid(mat, ridx, cidx)) {
				res += mat[ridx][cidx];
			}
		}
		return res;
	}

	public static int calculateLetters2(int[][] mat, int row, int col) {
		int res = 0;
		int[] rdir = { 2, 2, 2, 2, 2, 1, 1, 0, 0, -1, -1, -2, -2, -2, -2, -2 };
		int[] cdir = { -2, -1, 0, 1, 2, -2, 2, -2, 2, -2, 2, -2, -1, 0, 1, 2 };

		for (int i = 0; i < rdir.length; i++) {
			int ridx = rdir[i] + row;
			int cidx = cdir[i] + col;
			if (isValid(mat, ridx, cidx)) {
				res += mat[ridx][cidx];
			}
		}
		return res;
	}
}
