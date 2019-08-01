package InternQuestDP;

import java.util.Scanner;

public class Path_in_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int size = scn.nextInt();
			int[][] mat = new int[size][size];
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[0].length; j++) {
					mat[i][j] = scn.nextInt();
				}
			}

			int maxpath = Integer.MIN_VALUE;
			int dp[][] = new int[size][size];
			for (int i = 0; i < size; i++) {
				dp[0][i] = mat[0][i];
			}

			for (int i = 1; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (j == 0) {
						dp[i][j] = mat[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j + 1]);

					} else if (j == size - 1) {
						dp[i][j] = mat[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
					} else {
						dp[i][j] = mat[i][j] + Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j + 1]));
					}
				}
			}

			for (int i = 0; i < size; i++) {
				maxpath = Math.max(maxpath, dp[size - 1][i]);
			}

			System.out.println(maxpath);
		}

	}

}
