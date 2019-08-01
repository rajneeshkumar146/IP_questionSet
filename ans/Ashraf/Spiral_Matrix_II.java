package InternshipQuestionAs1;

import java.util.ArrayList;

public class Spiral_Matrix_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = generateMatrix(3);

		for (int c[] : a) {
			for (int v : c) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n) {

		int a[][] = new int[n][n];
		int rmin = 0;
		int rmax = a.length - 1;
		int cmax = a[0].length - 1;
		int cmin = 0;
		int te = (rmax + 1) * (cmax + 1);
		int count = 1;

		while (count <= te) {
			for (int j = cmin; j <= cmax && count <= te; j++) {
				a[rmin][j] = count;
				count++;
			}
			rmin++;

			for (int i = rmin; i <= rmax && count <= te; i++) {
				a[i][cmax] = count;
				count++;
			}
			cmax--;

			for (int j = cmax; j >= cmin && count <= te; j--) {
				a[rmax][j] = count;
				count++;
			}
			rmax--;

			for (int i = rmax; i >= rmin && count <= te; i--) {
				a[i][cmin] = count;
				count++;
			}
			cmin++;

		}
		return a;
	}
}
