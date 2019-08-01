package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_141FindCommonElements {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[scn.nextInt()][scn.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		//We have to find just one element which is common in all rows. 
		System.out.println(findCommon(arr));
	}

	static int findCommon(int mat[][]) {
		// An array to store indexes
		// of current last column
		int column[] = new int[mat.length];

		// To store index of row whose current
		// last element is minimum
		int min_row;

		// Initialize current last element of all rows
		int i;
		for (i = 0; i < mat.length; i++)
			column[i] = mat[0].length - 1;

		// Initialize min_row as first row
		min_row = 0;

		// Keep finding min_row in current last column, till either
		// all elements of last column become same or we hit first column.
		while (column[min_row] >= 0) {
			// Find minimum in current last column
			for (i = 0; i < mat.length; i++) {
				if (mat[i][column[i]] < mat[min_row][column[min_row]])
					min_row = i;
			}

			// eq_count is count of elements equal to minimum in current last
			// column.
			int eq_count = 0;

			// Traverse current last column elements again to update it
			for (i = 0; i < mat.length; i++) {
				// Decrease last column index of a row whose value is more
				// than minimum.
				if (mat[i][column[i]] > mat[min_row][column[min_row]]) {
					if (column[i] == 0)
						return -1;

					// Reduce last column index by 1
					column[i] -= 1;
				} else
					eq_count++;
			}

			// If equal count becomes M,
			// return the value
			if (eq_count == mat.length)
				return mat[min_row][column[min_row]];
		}
		return -1;
	}

}
/*
Test cases:
	4 4
	1 2 3 4
	2 4 5 8
	1 4 7 9
	1 4 5 8
	-------------------
	4


	4 5
	1 2 3 4 5
	2 4 5 8 9
	1 4 7 9 10
	1 4 5 8	11
	-------------------
	4
	
	5 5
	1 2 3 4 5
	2 4 5 8 9
	1 4	5 9 10
	1 4 5 8	11
	2 3 4 5 6
------------------------
	5
	
	Source: https://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/
*/