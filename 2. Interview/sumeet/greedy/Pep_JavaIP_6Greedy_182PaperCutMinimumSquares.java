package interview.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Pep_JavaIP_6Greedy_182PaperCutMinimumSquares {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int dim1 = scn.nextInt();
		int dim2 = scn.nextInt();

		int min = solve(dim1, dim2, new int[dim1 + 1][dim2 + 1]);
		System.out.println(min);
	}

	// qb is for memoizing
	// This looks greedy but is not - take 30 * 36 as example
	// Necessary to consider all options not just the next best.
	public static int solve(int dim1, int dim2, int[][] qb) {
		if (dim1 == 0 || dim2 == 0) {
			return 0;
		} else if (qb[dim1][dim2] != 0) {
			return qb[dim1][dim2];
		}

		int cut = Integer.MAX_VALUE;

		// squares of all sizes from 1 to min dimension possible
		for (int size = 1; size <= Math.min(dim1, dim2); size++) {
			// a cut creates two rectangles
			int cut1 = solve(dim1 - size, dim2, qb);
			int cut2 = solve(size, dim2 - size, qb);

			// just like mpc
			if (cut1 + cut2 + 1 <= cut) {
				cut = cut1 + cut2 + 1;
			}
		}

		qb[dim1][dim2] = cut;
		return cut;
	}

}
