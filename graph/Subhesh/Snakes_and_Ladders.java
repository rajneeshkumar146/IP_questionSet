package Graph;

import java.util.HashMap;
import java.util.LinkedList;

public class Snakes_and_Ladders {

	public static void main(String[] args) {
		int[][] arr = { { -1, -1, 19, 10, -1 }, { 2, -1, -1, 6, -1 }, { -1, 17, -1, 19, -1 }, { 25, -1, 20, -1, -1 },
				{ -1, -1, -1, -1, 15, } };
		System.out.println(snakesAndLadders(arr));
	}

	public static int snakesAndLadders(int[][] board) {
		HashMap<Integer, Integer> dist = new HashMap<>();
		LinkedList<Integer> queue = new LinkedList<>();
		dist.put(1, 0);
		queue.addLast(1);

		while (queue.size() != 0) {
			int rem = queue.remove();
			if (rem == board.length * board.length) {
				return dist.get(rem);
			}
			for (int i = rem + 1; i <= Math.min(rem + 6, board.length * board.length); i++) {
				int rc = get(i, board);
				int row = rc / board.length;
				int col = rc % board.length;
				int finalcell = i;
				if (board[row][col] != -1) {
					finalcell = board[row][col];
				}
				if (dist.containsKey(finalcell) == false) {
					dist.put(finalcell, dist.get(rem) + 1);
					queue.addLast(finalcell);
				}
			}
		}
		return -1;
	}

	private static int get(int cellno, int[][] board) {
		int r = (cellno - 1) / board.length;
		int c = (cellno - 1) % board.length;

		int row = board.length - 1 - r;
		int col = c;
		if (board.length % 2 == row % 2) {
			col = board.length - 1 - c;
		}
		return row * board.length + col;
	}
}
