package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_136NumberofIslands {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofrows = scn.nextInt();
		int noofcol = scn.nextInt();
		int[][] arr = new int[noofrows][noofcol];
		for (int i = 0; i < noofrows; i++) {
			for (int j = 0; j < noofcol; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1 && visited[i][j] == false) {
					countnumberofislands(arr, i, j, visited);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

	private static void countnumberofislands(int[][] arr, int row, int col, boolean[][] visited) {
		// negative base case
		if (isvalid(arr, row, col, visited) == false) {
			return;
		}

		visited[row][col] = true;
		countnumberofislands(arr, row - 1, col - 1, visited);
		countnumberofislands(arr, row - 1, col, visited);
		countnumberofislands(arr, row - 1, col + 1, visited);
		countnumberofislands(arr, row, col - 1, visited);
		countnumberofislands(arr, row, col + 1, visited);
		countnumberofislands(arr, row + 1, col - 1, visited);
		countnumberofislands(arr, row + 1, col, visited);
		countnumberofislands(arr, row + 1, col + 1, visited);

	}

	private static boolean isvalid(int[][] arr, int row, int col, boolean[][] visited) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
			return false;
		}
		if (arr[row][col] == 0) {
			return false;
		}
		if (visited[row][col] == true) {
			return false;
		}
		return true;
	}

}
/*
Test cases:
	4 4
	1 1 1 1
	0 1 1 0
	0 0 0 0
	1 0 1 0
	------------------
	3
	
	5 5
	1 0 0 0 1
	1 1 1 1 1
	0 0 0 0 0 
	1 1 1 0 0
	1 0 1 0 0
	----------------------
	2

	4 4
	1 0 0 1
	0 0 0 0 
	1 1 1 1
	0 0 0 1
	-------------------------
	3

	Source: https://www.geeksforgeeks.org/find-number-of-islands/
	*/