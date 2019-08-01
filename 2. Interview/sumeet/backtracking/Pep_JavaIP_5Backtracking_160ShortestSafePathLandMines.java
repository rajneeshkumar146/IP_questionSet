package interview.backtracking;

import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_160ShortestSafePathLandMines {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int row = scn.nextInt();
		int col = scn.nextInt();
		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		// mark adjacent cells of given matrix as unsafe
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 0) {
					if (i != 0 && arr[i - 1][j] != 0) {
						arr[i - 1][j] = 2;
					}
					if (i != arr.length - 1 && arr[i + 1][j] != 0) {
						arr[i + 1][j] = 2;
					}
					if (j != 0 && arr[i][j - 1] != 0) {
						arr[i][j - 1] = 2;
					}
					if (j != arr[0].length - 1 && arr[i][j + 1] != 0) {
						arr[i][j + 1] = 2;
					}
				}
			}
		}

		boolean[][] visited = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			findshortestsafepath(arr, i, 0, visited, 0);
		}
		System.out.println(csf - 1);
	}

	static int csf = Integer.MAX_VALUE;

	private static void findshortestsafepath(int[][] arr, int row, int col, boolean[][] visited, int count) {
		if (col == arr[0].length) {
			if (count < csf) {
				csf = count;
			}
			return;
		}

		if (isunsafe(arr, row, col, visited)) {
			return;
		}

		visited[row][col] = true;
		findshortestsafepath(arr, row + 1, col, visited, count + 1);// r
		findshortestsafepath(arr, row, col + 1, visited, count + 1);// t
		findshortestsafepath(arr, row, col - 1, visited, count + 1);// d
		findshortestsafepath(arr, row - 1, col, visited, count + 1);// l
		visited[row][col] = false;
	}

	private static boolean isunsafe(int[][] arr, int row, int col, boolean[][] visited) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || visited[row][col] == true
				|| arr[row][col] == 2 || arr[row][col] == 0) {
			return true;
		}
		return false;
	}

}
