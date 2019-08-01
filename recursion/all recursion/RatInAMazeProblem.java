
public class RatInAMazeProblem {

	public static void main(String[] args) {

	}
	public static void floodFill(int sr, int sc, int[][] maze, boolean[][] visited, String psf) {

		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			System.out.println(psf);
			return;
		}
		if (isInValidSpot(sr, sc, visited, maze) == true) {
			return;
		}

		visited[sr][sc] = true;
		floodFill(sr, sc - 1, maze, visited, psf + "L");
		floodFill(sr + 1, sc, maze, visited, psf + "D");
		floodFill(sr, sc + 1, maze, visited, psf + "R");
		floodFill(sr - 1, sc, maze, visited, psf + "U");
		visited[sr][sc] = false;

	}

	public static boolean isInValidSpot(int sr, int sc, boolean[][] visited, int[][] maze) {
		if (sr < 0) {
			return true;
		} else if (sc < 0) {
			return true;
		} else if (sr >= maze.length) {
			return true;
		} else if (sc >= maze[0].length) {
			return true;
		} else if (maze[sr][sc] == 0) {
			return true;
		} else if (visited[sr][sc] == true) {
			return true;
		} else {
			return false;
		}
	}

}
