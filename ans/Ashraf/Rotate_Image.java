package InternshipQuestionAs1;

public class Rotate_Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(a);
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[0].length; c++) {
				System.out.print(a[r][c] + "   ");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] a) {

		int rmax = a.length - 1;
		int cmin = 0;
		int cmax = a[0].length - 1;

		// transpose
		for (int r = 0; r <= rmax; r++) {
			for (int c = 0; c <= cmax; c++) {
				if (r < c) {
					int temp = a[r][c];
					a[r][c] = a[c][r];
					a[c][r] = temp;
				}
			}
		}

		while (cmin < cmax) {
			for (int r = 0; r <= rmax; r++) {
				int temp = a[r][cmin];
				a[r][cmin] = a[r][cmax];
				a[r][cmax] = temp;
			}
			cmin++;
			cmax--;
		}
	}
}
