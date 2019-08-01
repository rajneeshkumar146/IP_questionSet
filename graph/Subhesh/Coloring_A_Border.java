package Graph;

public class Coloring_A_Border {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 1, 2, 1, 2 }, { 2, 2, 2, 2, 1, 2 }, { 1, 2, 2, 2, 1, 2 } };
		int r0 = 1;
		int c0 = 3;
		int color = 1;
		int[][] ans = colorBorder(arr, r0, c0, color);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		int colorg = grid[r0][c0];
		int[][] permg = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				permg[i][j] = grid[i][j];
			}
		}
		bfs(grid, new boolean[grid.length][grid[0].length], r0, c0, color, colorg, permg);
		return grid;
	}

	private static void bfs(int[][] grid, boolean[][] visited, int r0, int c0, int color, int colorg, int[][] permg) {
		if (r0 < 0 || r0 >= grid.length || c0 < 0 || c0 >= grid[0].length) {
			return;
		}
		if (visited[r0][c0] == true) {
			return;
		}
		if (grid[r0][c0] != colorg) {
			return;
		}
		grid[r0][c0] = color;
		if (r0 - 1 >= 0 && permg[r0 - 1][c0] == colorg) {
			if (c0 - 1 >= 0 && permg[r0][c0 - 1] == colorg) {
				if (r0 + 1 < grid.length && permg[r0 + 1][c0] == colorg) {
					if (c0 + 1 < grid[0].length && permg[r0][c0 + 1] == colorg) {
						grid[r0][c0] = colorg;
					}
				}
			}
		}
		visited[r0][c0] = true;
		bfs(grid, visited, r0 + 1, c0, color, colorg, permg);
		bfs(grid, visited, r0, c0 + 1, color, colorg, permg);
		bfs(grid, visited, r0 - 1, c0, color, colorg, permg);
		bfs(grid, visited, r0, c0 - 1, color, colorg, permg);
	}
}
