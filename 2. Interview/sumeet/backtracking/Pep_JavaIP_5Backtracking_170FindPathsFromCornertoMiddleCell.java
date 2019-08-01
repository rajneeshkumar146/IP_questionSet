package interview.backtracking;

import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_170FindPathsFromCornertoMiddleCell {
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

		boolean[][] visited = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			findallpathsfromfirstcolumn(arr, i, 0, visited, "");
		}
	}

	private static void findallpathsfromfirstcolumn(int[][] arr, int row, int col, boolean[][] visited, String psf) {
		if (col == arr[0].length / 2 && row == arr.length / 2) {
			System.out.println(psf + "MID");
			return;
		}

		if (isunsafe(arr, row, col, visited)) {
			return;
		}
		// order of making calls : right, top, down, left
		visited[row][col] = true;
		findallpathsfromfirstcolumn(arr, row + arr[row][col], col, visited, psf + row + "" + col + " ");// r
		findallpathsfromfirstcolumn(arr, row, col + arr[row][col], visited, psf + row + "" + col + " ");// t
		findallpathsfromfirstcolumn(arr, row, col - arr[row][col], visited, psf + row + "" + col + " ");// d
		findallpathsfromfirstcolumn(arr, row - arr[row][col], col, visited, psf + row + "" + col + " ");// l
		visited[row][col] = false;
	}

	private static boolean isunsafe(int[][] arr, int row, int col, boolean[][] visited) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || visited[row][col] == true) {
			return true;
		}
		return false;
	}
}
