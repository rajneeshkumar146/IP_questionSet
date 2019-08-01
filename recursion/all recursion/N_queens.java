package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N_queens {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int z = 0; z < t; z++) {
			int n = Integer.parseInt(br.readLine());
			boolean[][] board = new boolean[n][n];
			ArrayList<Integer> list = new ArrayList<>();
			nqueensproactive(board, 0, list, -1);
			System.out.println();
		}
	}

	public static class Pair implements Comparable<Pair> {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public int compareTo(Pair o) {
			return this.col - o.col;
		}
	}

	static int count = 0;

	public static void nqueensproactive(boolean[][] board, int qno, ArrayList<Integer> psf, int begin) {
		if (qno == board.length) {
			ArrayList<Pair> list = new ArrayList<>();
			for (int i = 0; i < psf.size(); i++) {
				int row = psf.get(i) / board.length;
				int col = psf.get(i) % board.length;
				list.add(new Pair(row, col));
			}
			Collections.sort(list);
			System.out.print("[");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).row + 1 + " ");
			}
			System.out.print("] ");
			return;
		}
		for (int i = begin + 1; i < board.length * board[0].length; i++) {
			int row = i / board.length;
			int col = i % board.length;

			if (board[col][row] == false && isthequeensafe(board, col, row) == true) {
				board[col][row] = true;
				psf.add(i);
				nqueensproactive(board, qno + 1, psf, i);
				psf.remove(psf.size() - 1);
				board[col][row] = false;
			}
		}
	}

	private static boolean theboardisvalid(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == true) {
					if (isthequeensafe(board, i, j) == false) {
						return false;
					}
				}
			}
		}
		return true;

	}

	private static boolean isthequeensafe(boolean[][] board, int row, int col) {
		int[][] dir = { { -1, 0 }, { 1, -1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { -1, 1 }, { 0, -1 }, { -1, -1 } };
		for (int direc = 0; direc < dir.length; direc++) {
			int rad = 1;
			while (true) {
				int rdash = row + rad * dir[direc][0];
				int cdash = col + rad * dir[direc][1];
				if (rdash < 0 || rdash >= board.length) {
					break;
				}
				if (cdash < 0 || cdash >= board.length) {
					break;
				}
				if (board[rdash][cdash] == true) {
					return false;
				}
				rad++;
			}
		}
		return true;
	}
}
