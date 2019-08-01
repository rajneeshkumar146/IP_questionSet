package graphs;

public class UniquePaths2 {

	static int emptyCount = 1;
	static int counter = 0;

	public static void main(String[] args) {

		int[][] maze = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		int dr = -1;
		int sr = -1;
		int sc = -1;
		int dc = -1;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 1) {
					sr = i;
					sc = j;
				} else if (maze[i][j] == 2) {
					dr = i;
					dc = j;
				} else if (maze[i][j] == 0) {
					emptyCount++;
				}
			}
		}
//		System.out.println(moveInMaze(new boolean[maze.length][maze[0].length], maze, sr, sc, dr, dc));
		moveInMaze(new boolean[maze.length][maze[0].length], maze, sr, sc, dr, dc);
		System.out.println(counter);
	}

	public static void moveInMaze(boolean[][] visited, int[][] maze, int sr, int sc, int dr, int dc) {

		if (sr == dr && sc == dc) {
			if (emptyCount == 0) {
				counter++;
			}
			return;
		}

		if (isInvalid(visited, maze, sr, sc, dr, dc)) {
			return;
		}
		emptyCount--;
		visited[sr][sc] = true;
		moveInMaze(visited, maze, sr + 1, sc, dr, dc);
		moveInMaze(visited, maze, sr - 1, sc, dr, dc);
		moveInMaze(visited, maze, sr, sc + 1, dr, dc);
		moveInMaze(visited, maze, sr, sc - 1, dr, dc);
		emptyCount++;
		visited[sr][sc] = false;
	}

	public static boolean isInvalid(boolean[][] visited, int[][] maze, int sr, int sc, int dr, int dc) {

		if (sr < 0 || sr > maze.length - 1) {
			return true;
		} else if (sc < 0 || sc > maze[0].length - 1) {
			return true;
		} else if (visited[sr][sc]) {
			return true;
		} else if (maze[sr][sc] == -1) {
			return true;
		} else {
			return false;
		}

	}

}
