package pep_misc;

public class sum_of_ith_row_and_ith_col {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int r = 4;
		int c = 4;

		int arr[][] = { { 1, 2, 3, 4 }, { 9, 5, 3, 1 }, { 0, 3, 5, 6 }, { 0, 4, 5, 6 } };
		int[] rowsum = new int[r];
		int[] colsum = new int[c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				rowsum[i] += arr[i][j];
				colsum[j] += arr[i][j];
			}
		}

		if (res(rowsum, colsum)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	public static boolean res(int[] rowsum, int[] colsum) {
		for (int i = 0; i < Math.min(rowsum.length, colsum.length); i++) {
			if (rowsum[i] == colsum[i]) {
				return true;
			}
		}
		return false;
	}
}
