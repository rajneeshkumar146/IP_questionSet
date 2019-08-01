package BackTracking;

import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int z = 0; z < t; z++) {
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = scn.nextInt();
				}
			}
//		int[][] arr = new int[9][9];
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr[0].length; j++) {
//				arr[i][j] = scn.nextInt();
//			}
//		}
//		int[][] arr = new int[9][9];
			int[] rownos = new int[9];
			int[] colnos = new int[9];
			int[] sqrnos = new int[9];

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					makeachoice(arr, i * arr.length + j + 1, rownos, colnos, sqrnos, arr[i][j]);
				}
			}
			sudokum(arr, 1, rownos, colnos, sqrnos);
		}
	}

	private static void makeachoice(int[][] arr, int cellno, int[] rownos, int[] colnos, int[] sqrnos, int choice) {
		int rn = (cellno - 1) / arr.length;
		int cn = (cellno - 1) % arr.length;

		arr[rn][cn] = choice;
		rownos[rn] ^= (1 << choice);
		colnos[cn] ^= (1 << choice);
		sqrnos[rn / 3 * 3 + cn / 3] ^= (1 << choice);
	}

	private static void unmakeachoice(int[][] arr, int cellno, int[] rownos, int[] colnos, int[] sqrnos, int choice) {
		int rn = (cellno - 1) / arr.length;
		int cn = (cellno - 1) % arr.length;

		arr[rn][cn] = 0;
		rownos[rn] ^= (1 << choice);
		colnos[cn] ^= (1 << choice);
		sqrnos[rn / 3 * 3 + cn / 3] ^= (1 << choice);
	}

	private static void sudokum(int[][] arr, int cellno, int[] rownos, int[] colnos, int[] sqrnos) {
		if (cellno == 82) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
			return;
		}

		int rn = (cellno - 1) / arr.length;
		int cn = (cellno - 1) % arr.length;

		if (arr[rn][cn] == 0) {
			int rowor = rownos[rn];
			int color = colnos[cn];
			int sqror = sqrnos[rn / 3 * 3 + cn / 3];

			int or = rowor | color | sqror;
			for (int choice = 1; choice <= 9; choice++) {
				if ((or & (1 << choice)) == 0) {
					makeachoice(arr, cellno, rownos, colnos, sqrnos, choice);
					sudokum(arr, cellno + 1, rownos, colnos, sqrnos);
					unmakeachoice(arr, cellno, rownos, colnos, sqrnos, choice);
				}
			}
		} else {
			sudokum(arr, cellno + 1, rownos, colnos, sqrnos);
		}

	}

}
