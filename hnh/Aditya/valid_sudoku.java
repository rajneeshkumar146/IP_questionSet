package may27;

import java.util.HashMap;

public class valid_sudoku {

	public static void main(String[] args) {

	}

	class num {

		public int row;
		public int col;
		public int sub;

		public num() {
			this.row = 0;
			this.col = 0;
			this.sub = 0;

		}
	}

	 boolean isvalid(HashMap<Integer, num> numList, int val, int i, int j) {

		if (numList.containsKey(val)) {
			num test = numList.get(val);

			int v1 = (test.row & (1 << i));
			int v2 = (test.col & (1 << j));
			int v3 = (test.sub & (1 << ((i / 3) * 3 + (j / 3))));

			if (v1 != 0 || v2 != 0 || v3 != 0) {
				return false;
			} else {
				test.row = test.row | (1 << i);
				test.col = test.col | (1 << j);
				test.sub = test.sub | (1 << ((i / 3) * 3 + (j / 3)));
				numList.put(val, test);
				return true;
			}

		} else {
			num num = new num();
			num.row = num.row | (1 << i);
			num.col = num.col | (1 << j);
			num.sub = num.sub | (1 << ((i / 3) * 3 + (j / 3)));
			numList.put(val, num);
			return true;
		}

	}

	public boolean isValidSudoku(char[][] board) {

		HashMap<Integer, num> numList = new HashMap<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					if (!isvalid(numList, board[i][j], i, j)) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
