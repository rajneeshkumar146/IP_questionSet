package misc;

import java.util.Scanner;

public class largest_subsquare_surrounded_by_x {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int[][] A = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					A[i][j] = (int) scn.next().charAt(0);
				}
			}

			LargestSquare(A);
		}
	}

	public static void LargestSquare(int[][] arr) {

		int r = arr.length;
		int c = arr[0].length;
		int[][] harr = new int[r][c];
		int[][] varr = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {

				if (arr[i][j] == 'O') {
					harr[i][j] = varr[i][j] = 0;

				} else {
					harr[i][j] = j == 0 ? 1 : harr[i][j - 1] + 1;
					varr[i][j] = i == 0 ? 1 : varr[i - 1][j] + 1;
				}
			}
		}
		int max = 0;
		for (int i = r - 1; i >= 0; i--) {

			for (int j = c - 1; j >= 0; j--) {

				int minimum = Math.min(harr[i][j], varr[i][j]);

				while (minimum > max) {

					if (varr[i][j - minimum + 1] >= minimum && harr[i - minimum + 1][j] >= minimum) {
						max = minimum;
					}
					minimum--;
				}

			}
		}
		System.out.println(max);
	}

}
