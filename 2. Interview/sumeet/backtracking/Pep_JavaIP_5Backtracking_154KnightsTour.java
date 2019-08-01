package interview.backtracking;

import java.util.Scanner;

public class Pep_JavaIP_5Backtracking_154KnightsTour {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt(); // board size
		int x = scn.nextInt(); // start x
		int y = scn.nextInt(); // start y
		
		Integer[][] board = new Integer[n][n];
		int[] xdirs = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] ydirs = {1, 2, 2, 1, -1, -2, -2, -1};
		boolean res = solve(board, x, y, 1, xdirs, ydirs);
		System.out.println(res);
	}

	private static boolean solve(Integer[][] board, int x, int y, int moveNum, 
								 int[] xdirs, int[] ydirs){
		if(moveNum == board.length * board.length){
/*			board[x][y] = moveNum;
			for(int r = 0; r < board.length; r++){
				for(int c = 0; c < board[0].length; c++){
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
*/			return true;
		}
		
		board[x][y] = moveNum;
		
		for(int dir = 0; dir < xdirs.length; dir++){
			int xdash = x + xdirs[dir];
			int ydash = y + ydirs[dir];
			
			if(IsValidMove(board, xdash, ydash) == false){
				continue;
			} else {
				boolean rres = solve(board, xdash, ydash, moveNum + 1, xdirs, ydirs);
				if (rres == true){
					return true;
				}
			}
		}
		
		board[x][y] = null;
		return false;
	}

	private static boolean IsValidMove(Integer[][] board, int row, int col) {
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
			return false;
		}
		
		return board[row][col] == null; // open box is valid, fill box is not
	}

}
