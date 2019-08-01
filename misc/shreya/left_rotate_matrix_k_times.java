package misc;

import java.util.Scanner;

public class left_rotate_matrix_k_times {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int m = scn.nextInt();
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[][] A = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					A[i][j] = scn.nextInt();
				}
			}
			leftRotate(A, k);
		}
	}

	public static void leftRotate(int[][] mat, int k) {

		for (int i = 0; i < mat.length; i++) {
			int count = 0;
			while (count < k) {
				int temp = mat[i][0];
				for (int j = 0; j < mat[0].length - 1; j++) {
					mat[i][j] = mat[i][j + 1];
				}
				mat[i][mat[0].length - 1] = temp;
				count++;
			}
		}
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
		}
		System.out.println();
	}
}
