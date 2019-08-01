package misc;

import java.util.Scanner;

public class kronecker_product {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int m = scn.nextInt();
			int n = scn.nextInt();
			int p = scn.nextInt();
			int q = scn.nextInt();
			int[][] A = new int[m][n];
			int[][] B = new int[p][q];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					A[i][j] = scn.nextInt();
				}
			}
			for (int i = 0; i < p; i++) {
				for (int j = 0; j < q; j++) {
					B[i][j] = scn.nextInt();
				}
			}

			int[][] C = new int[m * p][n * q];

			findProduct(C, A, B);
		}
	}

	public static void findProduct(int[][] C, int[][] A, int[][] B) {
		for (int rowa = 0; rowa < A.length; rowa++) {

			for (int rowb = 0; rowb < B.length; rowb++) {

				for (int cola = 0; cola < A[0].length; cola++) {

					for (int colb = 0; colb < B[0].length; colb++) {

						C[rowa + colb + 1][cola + rowb + 1] = A[rowa][cola] * B[rowb][colb];
						System.out.print(C[rowa + colb + 1][cola + rowb + 1] + " ");
					}
				}
				System.out.println();
			}
		}
	}
}
