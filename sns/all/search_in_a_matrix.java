package SnS;

import java.util.Scanner;

public class search_in_a_matrix {

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
			int val = scn.nextInt();

			int res = search(mat, val);
			System.out.println(res);
		}
	}

	public static int search(int[][] mat, int val) {
		int i = 0, j = mat[0].length - 1;

		while (i < mat.length && j >= 0) {
			if (mat[i][j] == val) {
				return 1;
			} else if (mat[i][j] > val) {
				j--;
			} else {
				i++;
			}
		}

		return 0;
	}

}
