package InternshipQuestionAs1;

import java.util.ArrayList;

public class Spiral_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Integer> spiralOrder(int[][] a) {

		if (a.length == 0 || a[0].length == 0) {
			return new ArrayList<>();
		}

		int rmin = 0;
		int rmax = a.length - 1;
		int cmax = a[0].length - 1;
		int cmin = 0;
		int te = (rmax + 1) * (cmax + 1);
		int count = 1;

		ArrayList<Integer> ans = new ArrayList<>();

		while (count <= te) {
			for (int j = cmin; j <= cmax && count <= te; j++) {
				ans.add(a[rmin][j]);
				count++;
			}
			rmin++;

			for (int i = rmin; i <= rmax && count <= te; i++) {
				ans.add(a[i][cmax]);
				count++;
			}
			cmax--;

			for (int j = cmax; j >= cmin && count <= te; j--) {
				ans.add(a[rmax][j]);
				count++;
			}
			rmax--;

			for (int i = rmax; i >= rmin && count <= te; i--) {
				ans.add(a[i][cmin]);
				count++;
			}
			cmin++;

		}
		return ans;

	}
}
