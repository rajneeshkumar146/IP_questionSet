package Graph;

public class Minesweeper {

	public static void main(String[] args) {
		char[][] board = { { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M' },
				{ 'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E' }, { 'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E' } };
		int[] click = { 0, 0 };
		char[][] ans = updateBoard(board, click);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static char[][] updateBoard(char[][] board, int[] click) {
		int row = click[0];
		int col = click[1];

		if (board[row][col] == 'M') {
			board[row][col] = 'X';
		} else {
			dfs(row, col, board);
		}
		return board;
	}

	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	private static void dfs(int row, int col, char[][] board) {
		if (checkformine(row, col, board) == false) {
			board[row][col] = 'B';
			for (int i = 0; i < 4; i++) {
				int rdash = row + dir[i][0];
				int cdash = col + dir[i][1];
				if (rdash >= 0 && cdash >= 0 && rdash < board.length && cdash < board[0].length
						&& board[rdash][cdash] == 'E') {
					dfs(rdash, cdash, board);
				}
			}
		} else {
			board[row][col] = (char) ('0' + count);
		}
	}

	static int count;

	private static boolean checkformine(int row, int col, char[][] board) {
		int[][] arr = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
		count = 0;
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			int rdash = row + arr[i][0];
			int cdash = col + arr[i][1];

			if (rdash >= 0 && cdash >= 0 && rdash < board.length && cdash < board[0].length
					&& (board[rdash][cdash] == 'M' || board[rdash][cdash] == 'X')) {
				count++;
				flag = true;
			}
		}
		return flag;
	}

	public char[][] updateBoardres(char[][] board, int[] click) {
		int m = board.length, n = board[0].length;
		int row = click[0], col = click[1];

		if (board[row][col] == 'M') { // Mine
			board[row][col] = 'X';
		} else { // Empty
					// Get number of mines first.
			int count = 0;
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (i == 0 && j == 0)
						continue;
					int r = row + i, c = col + j;
					if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
						continue;
					if (board[r][c] == 'M' || board[r][c] == 'X')
						count++;
				}
			}

			if (count > 0) { // If it is not a 'B', stop further DFS.
				board[row][col] = (char) (count + '0');
			} else { // Continue DFS to adjacent cells.
				board[row][col] = 'B';
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == 0 && j == 0)
							continue;
						int r = row + i, c = col + j;
						if (r < 0 || r >= m || c < 0 || c < 0 || c >= n)
							continue;
						if (board[r][c] == 'E')
							updateBoard(board, new int[] { r, c });
					}
				}
			}
		}

		return board;
	}
}
