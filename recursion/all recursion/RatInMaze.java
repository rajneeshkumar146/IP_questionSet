package recursion;

import java.util.ArrayList;
import java.util.Collections;

class RatInAMaze {
	public static ArrayList<String> arr;

	public static ArrayList<String> printPath(int[][] m, int n) {
		if (n == 0) {
			return null;
		}
		arr = new ArrayList<String>();
		String s = "";
		ans(m, n, s, 0, 0);
		Collections.sort(arr);
		return arr;
	}

	static void ans(int m[][], int n, String s, int row, int col) {
		if (row == n - 1 && col == n - 1) {
			arr.add(s);
			return;
		}
		m[row][col] = 0;

		if (isValid(m, row, col + 1, n)) {
			ans(m, n, s + "R", row, col + 1);
		}
		if (isValid(m, row + 1, col, n)) {
			ans(m, n, s + "D", row + 1, col);
		}
		if (isValid(m, row - 1, col, n)) {
			ans(m, n, s + "U", row - 1, col);
		}
		if (isValid(m, row, col - 1, n)) {
			ans(m, n, s + "L", row, col - 1);
		}

		m[row][col] = 1;
		return;
	}

	static boolean isValid(int m[][], int row, int col, int n) {
		if (row < 0 || row >= n || col < 0 || col >= n || m[row][col] == 0) {
			return false;
		}
		return true;
	}
}