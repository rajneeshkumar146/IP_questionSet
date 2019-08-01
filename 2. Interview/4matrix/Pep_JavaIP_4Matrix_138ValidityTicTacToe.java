package Matrix;

import java.util.Scanner;

public class Pep_JavaIP_4Matrix_138ValidityTicTacToe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[] arr = new char[9];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.next().charAt(0);
		}

		System.out.println(checkvalidity(arr));
		scn.close();
	}

	private static boolean checkvalidity(char[] board) {
		int countX = 0, countO = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 'X') {
				countX++;
			} else if(board[i]=='O') {
				countO++;
			}
		}

		if (countO == countX || countO + 1 == countX) {
			if (cWin(board, 'O')) {
				if (cWin(board, 'X')) {
					return false;
				}

				return countO == countX;
			}
			if (cWin(board, 'X') && countX != countO)
				return false;

			return true;
		}
		return false;

	}

	private static boolean cWin(char[] board, char c) {
		int[][] win = { { 0, 1, 2 }, // Check first row.
				{ 3, 4, 5 }, // Check second Row
				{ 6, 7, 8 }, // Check third Row
				{ 0, 3, 6 }, // Check first column
				{ 1, 4, 7 }, // Check second Column
				{ 2, 5, 8 }, // Check third Column
				{ 0, 4, 8 }, // Check first Diagonal
				{ 2, 4, 6 } }; // Check second Diagonal

		for (int i = 0; i < 8; i++) {
			if (board[win[i][0]] == c && board[win[i][1]] == c && board[win[i][2]] == c)
				return true;
		}

		return false;
	}

}

/*
Test cases:
	X X O
	O O X
	X X O
	---------------
	true
	
	X X O
	O O X
	O O O
	--------------------
	false
	
	X X _
	O _ _
	O _ _
	--------------------
	true
Source: https://www.geeksforgeeks.org/given-matrix-o-x-find-largest-subsquare-surrounded-x/	
*/