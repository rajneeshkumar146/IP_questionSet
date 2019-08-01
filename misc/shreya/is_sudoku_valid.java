package misc;

import java.util.HashSet;
import java.util.Scanner;

public class is_sudoku_valid {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		for (int t = 0; t < test; t++) {
			int[][] sudoku = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = scn.nextInt();
				}
			}

			int res = checkValid(sudoku);
			System.out.println(res);
		}
	}

	public static boolean checkInRow(int[][] sudoku, int row) {
		HashSet<Integer> set = new HashSet<>();

		for (int col = 0; col < 9; col++) {
			if (sudoku[row][col] != 0 && set.contains(sudoku[row][col])) {
				return false;
			}
			if (sudoku[row][col] != 0) {
				set.add(sudoku[row][col]);
			}
		}
		return true;
	}

	public static boolean checkInCol(int[][] sudoku, int col) {
		HashSet<Integer> set = new HashSet<>();

		for (int row = 0; row < 9; row++) {
			if (sudoku[row][col] != 0 && set.contains(sudoku[row][col])) {
				return false;
			}
			if (sudoku[row][col] != 0) {
				set.add(sudoku[row][col]);
			}
		}
		return true;
	}

	public static boolean checkInBox(int[][] sudoku, int strow, int stcol) {
		HashSet<Integer> set = new HashSet<>();

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				int val = sudoku[strow + row][stcol + col];
				if (set.contains(val)) {
					return false;
				}
				if (val != 0) {
					set.add(val);
				}
			}
		}
		return true;
	}

	public static int checkValid(int[][] sudoku) {
		for (int row = 0; row < sudoku.length; row++) {
			for (int col = 0; col < sudoku[0].length; col++) {

				boolean rres = checkInRow(sudoku, row);
				boolean cres = checkInCol(sudoku, col);
				boolean bres = checkInBox(sudoku, row - (row % 3), col - (col % 3));
				if (!rres || !cres || !bres) {
					return 0;
				}
			}
		}
		return 1;

	}
}
