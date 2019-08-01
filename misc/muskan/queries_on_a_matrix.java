package pep_misc;

import java.util.Scanner;

public class queries_on_a_matrix {
	/*
	 * 1
6 6
4 0 5 3
0 0 3 4
1 2 1 2
1 1 2 3
0 0 3 1
1 0 2 4
	 */

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int n = scn.nextInt();
			int q = scn.nextInt();
			int[][] newmat = new int[n][n + 1];
			for (int i = 0; i < q; i++) {
				int r1 = scn.nextInt();
				int c1 = scn.nextInt();
				int r2 = scn.nextInt();
				int c2 = scn.nextInt();
				for (int j = r1; j <= r2; j++) {
					newmat[j][c1] += 1;
					newmat[j][c2 + 1] -= 1;
				}
			}
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					sum += newmat[i][j];
					newmat[i][j] = sum;
					System.out.print(newmat[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
