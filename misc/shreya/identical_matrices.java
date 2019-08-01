package misc;

import java.util.Scanner;

public class identical_matrices {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[][] mat1 = new int[n][n];
			int[][] mat2 = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat1[i][j] = scn.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat2[i][j] = scn.nextInt();
				}
			}

			String flag = "Yes";
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mat1[i][j] != mat2[i][j]) {
						flag = "No";
						break;
					}
				}
			}

			System.out.println(flag);
		}

	}
}
