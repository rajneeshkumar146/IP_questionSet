package misc;

import java.util.Scanner;

public class largest_rectangle_of_1_with_swapping_column_allowed {

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

			findTheLargestRectangle(A);
		}

	}

	public static void findTheLargestRectangle(int[][] mat) {

		int[][] temp = new int[mat.length][mat[0].length];
		int c = mat[0].length;
		int r = mat.length;
		// counting consecutive 1
		for (int j = 0; j < mat[0].length; j++) {
			temp[0][j] = mat[0][j];

			for (int i = 1; i < mat.length; i++) {
				temp[i][j] = (mat[i][j] == 0) ? 0 : temp[i - 1][j] + 1;
			}
		}

		for (int i = 0; i < temp.length; i++) {
			int[] count = new int[r + 1];
			for (int col = 0; col < c; col++) {
				count[temp[i][col]]++;
			}
			int colno = 0;
			for (int j = count.length - 1; j >= 0; j--) {
				if (count[j] > 0) {
					int k = 0;
					while (k < count[j]) {
						temp[i][colno++] = j;
						k++;
					}
				}
			}
		}
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {

				int curArea = (j + 1) * temp[i][j];
				maxArea = Math.max(curArea, maxArea);
			}
		}

		System.out.println(maxArea);
	}
}
