package misc;

import java.util.Scanner;

public class RowWithMin1s {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int testCase = s.nextInt();
		for (int i = 0; i < testCase; i++) {
			int n = s.nextInt();
			int m = s.nextInt();
			int[][] mat = new int[n][m];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					mat[j][k] = s.nextInt();
				}
			}
			System.out.println(printRowWithMin1s(mat));
		}

	}

	public static int printRowWithMin1s(int[][] mat) {

		int minRowIdx = -1;
		int minNumberOf1s = Integer.MAX_VALUE;
		for (int i = 0; i < mat.length; i++) {
			int num = 0;
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					num++;
				}
			}
			if (num < minNumberOf1s && num != 0) {
				minNumberOf1s = num;
				minRowIdx=i;
			}
		}

		return minRowIdx;

	}
}
