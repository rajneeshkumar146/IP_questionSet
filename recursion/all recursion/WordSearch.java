package recursion;

public class WordSearch {

	public static void main(String[] args) {

	}

	public boolean exist(char[][] board, String word) {
		if (board == null || word == null)
			return false;
		if (word.length() == 0)
			return true;

		char[] w = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (exist(board, i, j, w, 0))
					return true;
			}
		}

		return false;
	}

	private boolean exist(char[][] board, int r, int c, char[] word, int index) {
		if (board[r][c] == word[index]) {
			char save = board[r][c];
			board[r][c] = 0;
			if ((index == word.length - 1) || (r > 0 && exist(board, r - 1, c, word, index + 1))
					|| (c > 0 && exist(board, r, c - 1, word, index + 1))
					|| (r < board.length - 1 && exist(board, r + 1, c, word, index + 1))
					|| (c < board[r].length - 1 && exist(board, r, c + 1, word, index + 1)))
				return true;
			board[r][c] = save;
		}
		return false;
	}
}
