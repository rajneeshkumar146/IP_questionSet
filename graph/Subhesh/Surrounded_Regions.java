package Graph;

public class Surrounded_Regions {
	public static void main(String[] args) {

	}

	public void solve(char[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
					if (board[i][j] == 'O') {
						ChangetoP(board, i, j);
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if ((i == 0 || i == board.length - 1) && (j == 0 || j == board[0].length - 1)) {
					continue;
				} else {
					if (board[i][j] == 'O') {
						board[i][j] = 'X';
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'p') {
					board[i][j] = 'O';
				}
			}
		}

	}

	static void ChangetoP(char[][] board, int i, int j) {
		board[i][j] = 'p';

		int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

		for (int[] x : dirs) {
			int newx = i + x[0];
			int newy = j + x[1];

			if (newx >= 0 && newx < board.length && newy >= 0 && newy < board[0].length && board[newx][newy] == 'O') {
				ChangetoP(board, newx, newy);
			}
		}
	}
}
