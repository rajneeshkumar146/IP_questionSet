

public class RatMazeWithMultipleJumps {

	public static void main(String[] args) {

		int n = 4;
		int[][] maze = { { 2, 1, 0, 0 }, { 3, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 0, 0, 1 } };
		int[][] solution = new int[n][n];
		solution[0][0] = 1;
		System.out.println(mazePath(maze, 0, 0, solution));
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution[0].length; j++) {
				System.out.print(solution[i][j] + "");
			}
			System.out.println();
		}
	}

	public static boolean mazePath(int[][] maze, int sr, int sc, int[][] output) {

		if (sr > maze.length - 1 || sc > maze[0].length - 1) {
			return false;
		}
		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			return true;
		}
		int steps = maze[sr][sc];

		for (int i = 1; i <= steps; i++) {
			if (sc + i < maze[0].length && maze[sr][sc + i] != 0) {
				output[sr][sc + i] = 1;
				boolean path = mazePath(maze, sr, sc + i, output);
				if (path) {
					return true;
				} else {
					output[sr][sc + i] = 0;
				}
			}
			if (sr + i < maze.length && maze[sr + i][sc] != 0) {
				output[sr + i][sc] = 1;
				boolean path = mazePath(maze, sr + i, sc, output);
				if (path) {
					return true;
				} else {
					output[sr + i][sc] = 0;
				}
			}

		}

		return false;

	}
}
