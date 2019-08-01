package interview.backtracking;

import java.util.HashSet;
import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_156Sudoku {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[9][9];

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				arr[r][c] = scn.nextInt();
			}
		}

		initOptions(arr);
		solve(arr, 0);
	}

	private static boolean solve(int[][] arr, int cell) {
		if (cell == 81) {
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}

			return true;
		}

		int row = cell / 9;
		int col = cell % 9;

		if (arr[row][col] == 0) {
			for (int option = 1; option <= 9; option++) {
				if (isValidOption(option, row, col) == true) {
					setOption(arr, row, col, option);

					boolean rres = solve(arr, cell + 1);
					if (rres == true) {
						return true;
					}

					resetOption(arr, row, col, option);
				}
			}
		} else {
			boolean rres = solve(arr, cell + 1);
			if (rres == true) {
				return true;
			}
		}

		return false;
	}

	static HashSet<Integer>[] rNonOptions;
	static HashSet<Integer>[] cNonOptions;
	static HashSet<Integer>[][] smNonOptions;

	private static void initOptions(int[][] arr) {
		rNonOptions = new HashSet[9];
		cNonOptions = new HashSet[9];
		smNonOptions = new HashSet[3][3]; // sub-matrix

		for (int r = 0; r < 9; r++) {
			rNonOptions[r] = new HashSet<>();
			for (int c = 0; c < 9; c++) {
				if (arr[r][c] != 0) {
					rNonOptions[r].add(arr[r][c]);
				}
			}
		}

		for (int c = 0; c < 9; c++) {
			cNonOptions[c] = new HashSet<>();
			for (int r = 0; r < 9; r++) {
				if (arr[r][c] != 0) {
					cNonOptions[c].add(arr[r][c]);
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				smNonOptions[i][j] = new HashSet<>();

				for (int r = 3 * i; r < 3 * i + 3; r++) {
					for (int c = 3 * j; c < 3 * j + 3; c++) {
						if (arr[r][c] != 0) {
							smNonOptions[i][j].add(arr[r][c]);
						}
					}
				}
			}
		}
	}

	private static boolean isValidOption(int option, int row, int col) {
		if (rNonOptions[row].contains(option)) {
			return false;
		} else if (cNonOptions[col].contains(option)) {
			return false;
		} else if (smNonOptions[row / 3][col / 3].contains(option)) {
			return false;
		} else {
			return true;
		}
	}

	private static void setOption(int[][] arr, int row, int col, int val) {
		arr[row][col] = val;
		rNonOptions[row].add(val);
		cNonOptions[col].add(val);
		smNonOptions[row / 3][col / 3].add(val);
	}

	private static void resetOption(int[][] arr, int row, int col, int val) {
		arr[row][col] = 0;
		rNonOptions[row].remove(val);
		cNonOptions[col].remove(val);
		smNonOptions[row / 3][col / 3].remove(val);
	}
}
