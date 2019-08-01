package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_144FindSpecificPair {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[scn.nextInt()][scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		System.out.println(findpair(arr));
	}

	private static int findpair(int[][] arr) {

		// preprocess kar lo ek matrix
		int[][] mat = new int[arr.length][arr[0].length];
		int maxvalue = arr[arr.length - 1][arr[0].length - 1];
		// last value ko bnao
		mat[arr.length - 1][arr[0].length - 1] = arr[arr.length - 1][arr[0].length - 1];
		// last column ko banao
		for (int i = arr.length - 2; i >= 0; i--) {
			if (maxvalue < arr[i][arr[0].length - 1]) {
				maxvalue = arr[i][arr[0].length - 1];
			}
			mat[i][arr[0].length - 1] = maxvalue;
		}

		// last row ko prepare kar lo
		for (int i = arr.length - 2; i >= 0; i--) {
			if (maxvalue < arr[arr.length - 1][i]) {
				maxvalue = arr[arr.length - 1][i];
			}
			mat[arr.length - 1][i] = maxvalue;
		}

		// rest of the matrix
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr[0].length - 2; j >= 0; j--) {
				if (mat[i + 1][j + 1] - arr[i][j] > maxvalue) {
					maxvalue = mat[i + 1][j + 1] - arr[i][j];
				}

				mat[i][j] = Math.max(arr[i][j], Math.max(mat[i + 1][j], mat[i][j + 1]));
			}
		}

		return maxvalue;
	}

}
/*
Test cases:
	5 5
	1 2 -1 -4 -20
	-8 -3 4 2 1
	3 8 6 1 3
	-4 -1 1 7 -6
	0 4 10 -5 1
	----------------------------
	18
	
	5 5
	-1 -2 3 4 5
	1 2 3 4 5
	1 2 3 4 5
	1 2 3 4 5
	1 2 3 4 5
	--------------------
	7
	
	5 5
	1 2 -1 -4 -20
	-8 -3 4 2 1
	3 8 6 1 3
	-4 -1 1 7 -6
	0 4 12 -5 1
	-----------------------
	20
	
	Source: https://www.geeksforgeeks.org/find-a-specific-pair-in-matrix/
*/