package pep_misc;

import java.util.ArrayList;

public class make_zeroes {

	public static class Pair {
		int r;
		int c;
		int val;

		Pair(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int m = 4;
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 0, 7 }, { 8, 9, 4, 6 }, { 8, 4, 5, 2 } };
		ArrayList<Pair> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					int sum = 0;
					list.add(new Pair(i, j, sum));
				}
			}
		}
		for (int k = 0; k < list.size(); k++) {
			Pair p = list.get(k);
			int i = p.r;
			int j = p.c;
			int sum = p.val;

			if (i - 1 >= 0) {
				sum += arr[i - 1][j];
			}
			if (j - 1 >= 0) {
				sum += arr[i][j - 1];
			}
			if (i + 1 < n) {
				sum += arr[i + 1][j];
			}
			if (j + 1 < m) {
				sum += arr[i][j + 1];
			}
			p.val = sum;
		}
		for (int i = 0; i < list.size(); i++) {
			Pair p = list.get(i);
			int r = p.r;
			int c = p.c;
			if (r - 1 >= 0) {
				arr[r - 1][c] = 0;
			}
			if (c - 1 >= 0) {
				arr[r][c - 1] = 0;
			}
			if (r + 1 < n) {
				arr[r + 1][c] = 0;
			}
			if (c + 1 < m) {
				arr[r][c + 1] = 0;
			}
			arr[r][c] = p.val;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
