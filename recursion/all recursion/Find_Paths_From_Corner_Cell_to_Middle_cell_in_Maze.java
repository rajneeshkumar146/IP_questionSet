package BackTracking;

import java.util.ArrayList;

public class Find_Paths_From_Corner_Cell_to_Middle_cell_in_Maze {

	public static void main(String[] args) {
		int[][] arr = { { 3, 5, 4, 4, 7, 3, 4, 6, 3 }, { 6, 7, 5, 6, 6, 2, 6, 6, 2 }, { 3, 3, 4, 3, 2, 5, 4, 7, 2 },
				{ 6, 5, 5, 1, 2, 3, 6, 5, 6 }, { 3, 3, 4, 3, 0, 1, 4, 3, 4 }, { 3, 5, 4, 3, 2, 2, 3, 3, 5 },
				{ 3, 5, 4, 3, 2, 6, 4, 4, 3 }, { 3, 5, 1, 3, 7, 5, 3, 6, 4 }, { 6, 2, 4, 3, 4, 5, 4, 5, 1 } };
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		ArrayList<Pair> list = new ArrayList<>();
		findpathmaze(arr, 0, 0, arr.length / 2, arr[0].length / 2, visited, list);
	}

	private static void findpathmaze(int[][] arr, int cr, int cc, int dr, int dc, boolean[][] visited,
			ArrayList<Pair> list) {
		if (cr < 0 || cc < 0 || cr >= arr.length || cc >= arr[0].length) {
			return;
		}
		if (cr == dr && cc == dc) {
			list.add(new Pair(dr, dc));
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i).row + " " + list.get(i).col+"      ");
			}
			System.out.println();
			list.remove(list.size() - 1);
			return;
		}
		if (visited[cr][cc] == true) {
			return;
		}
		int val = arr[cr][cc];
		visited[cr][cc] = true;
		list.add(new Pair(cr, cc));
		findpathmaze(arr, cr + val, cc, dr, dc, visited, list);
		findpathmaze(arr, cr - val, cc, dr, dc, visited, list);
		findpathmaze(arr, cr, cc + val, dr, dc, visited, list);
		findpathmaze(arr, cr, cc - val, dr, dc, visited, list);
		list.remove(list.size() - 1);
		visited[cr][cc] = false;
	}

	public static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
