package misc;

import java.util.Scanner;

public class lets_play {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int m = scn.nextInt();
			int n = scn.nextInt();
			int[][] A = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					A[i][j] = scn.nextInt();
				}
			}
			int k = scn.nextInt();

			leftRightRotate(A, k);
		}
	}

	public static void leftRightRotate(int[][] mat, int k) {
		int[][] tempMat = new int[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				tempMat[i][j] = mat[i][j];
			}
		}

		for (int i = 0; i < mat.length; i++) {
			int count = 0;
			if (i % 2 == 0) {
				while (count < k) {
					int temp = mat[i][0];
					for (int j = 0; j < mat[0].length - 1; j++) {
						mat[i][j] = mat[i][j + 1];
					}
					mat[i][mat[0].length - 1] = temp;
					count++;
				}
			} else {
				while (count < k) {
					int temp = mat[i][mat[0].length - 1];
					for (int j = mat[0].length - 2; j >= 0; j--) {
						mat[i][j + 1] = mat[i][j];
					}
					mat[i][0] = temp;
					count++;
				}
			}
		}
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (tempMat[i][j] != mat[i][j]) {
					System.out.println(0);
					return;
				}
			}
		}
		System.out.println(1);
	}
}
