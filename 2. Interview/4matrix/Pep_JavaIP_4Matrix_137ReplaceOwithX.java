package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_137ReplaceOwithX {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofrows = scn.nextInt();
		int noofcol = scn.nextInt();
		char[][] arr = new char[noofrows][noofcol];
		for (int i = 0; i < noofrows; i++) {
			for (int j = 0; j < noofcol; j++) {
				arr[i][j] = scn.next().charAt(0);
			}
		}

		// replace all O's with '-'
		for (int i = 0; i < noofrows; i++) {
			for (int j = 0; j < noofcol; j++) {
				if (arr[i][j] == 'O')
					arr[i][j] = '-';
			}
		}
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if ((i == 0 || i == arr.length - 1) && visited[i][j] == false && arr[i][j]=='-') {
					replaceOX(arr, i, j, visited);
				}
				
				if ((j == 0 || j == arr.length - 1) && visited[i][j] == false && arr[i][j]=='-') {
					replaceOX(arr, i, j, visited);
				}
			}
		}
		
		for (int i = 0; i < noofrows; i++) {
			for (int j = 0; j < noofcol; j++) {
				if (arr[i][j] == '-')
					arr[i][j] = 'X';
			}
		}
		
		for (int i = 0; i < noofrows; i++) {
			for (int j = 0; j < noofcol; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	private static void replaceOX(char[][] arr, int row, int col, boolean[][] visited) {
		// negative base case
		if (isvalid(arr, row, col, visited) == false) {
			return;
		}
		if(arr[row][col]=='-') {
			arr[row][col]='O';
		}
		visited[row][col] = true;
		replaceOX(arr, row - 1, col - 1, visited);
		replaceOX(arr, row - 1, col, visited);
		replaceOX(arr, row - 1, col + 1, visited);
		replaceOX(arr, row, col - 1, visited);
		replaceOX(arr, row, col + 1, visited);
		replaceOX(arr, row + 1, col - 1, visited);
		replaceOX(arr, row + 1, col, visited);
		replaceOX(arr, row + 1, col + 1, visited);

	}

	private static boolean isvalid(char[][] arr, int row, int col, boolean[][] visited) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length) {
			return false;
		}
		if (arr[row][col] == 'X') {
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
X X O X
X O O X
X X X X
X X X X
-------------------------
XXOX
XOOX
XXXX
XXXX

6 6 
X O X X X X
X O X X O X
X X X O O X
O X X X X X
X X X O X O
O O X O O O
-----------------------
XOXXXX
XOXXXX
XXXXXX
OXXXXX
XXXOXO
OOXOOO

Source: https://www.geeksforgeeks.org/given-matrix-o-x-replace-o-x-surrounded-x/

*/