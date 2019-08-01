package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Maze3 {

	public static void main(String[] args) {

		int[][] maze = { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 0 } };

		int[] source = { 4, 3 };
		int[] destination = { 0, 1 };
		System.out.println(findShortestPath(maze, source, destination));

	}

	public static String findShortestPath(int[][] maze, int[] ball, int[] hole) {

		int sr = ball[0];
		int sc = ball[1];
		int dr = hole[0];
		int dc = hole[1];

		boolean[][] visited = new boolean[maze.length][maze[0].length];
		LinkedList<Status> queue = new LinkedList<Status>();
		queue.add(new Status(sr, sc, 0, 0, ""));

		while (!queue.isEmpty()) {
			Status cur = queue.removeFirst();
			if (cur.x < 0 || cur.y < 0 || cur.x >= maze.length || cur.y >= maze[0].length || maze[cur.x][cur.y] == 1) {
				continue;
			}
			if (visited[cur.x][cur.y]) {
				continue;
			}
			if (cur.x == dr && cur.y == dc) {
				return cur.path;
			}

			// If the ball was rolling in some direction
			if (cur.dirX != 0 || cur.dirY != 0) {
				int newX = cur.x + cur.dirX;
				int newY = cur.y + cur.dirY;

				// checking whether the ball is hitting the hitting the wall
				if (newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length || maze[newX][newY]==1) {
					cur.dirX = 0;
					cur.dirY = 0;
				}
				// else keep rolling
				else {
					queue.addLast(new Status(newX, newY, cur.dirX, cur.dirY, cur.path));
				}
			}

			if (cur.dirX == 0 && cur.dirY == 0) {
				visited[cur.x][cur.y] = true;
				queue.addLast(new Status(cur.x + 1, cur.y, 1, 0, cur.path + "d"));
				queue.addLast(new Status(cur.x, cur.y - 1, 0, -1, cur.path + "l"));
				queue.addLast(new Status(cur.x, cur.y + 1, 0, 1, cur.path + "r"));
				queue.addLast(new Status(cur.x - 1, cur.y, -1, 0, cur.path + "u"));
			}

		}
		return "impossible";

	}
}

class Status {
	int x;
	int y;
	int dirX;
	int dirY;
	String path;

	public Status(int x, int y, int dirX, int dirY, String path) {

		this.x = x;
		this.y = y;
		this.dirX = dirX;
		this.dirY = dirY;
		this.path = path;

	}

}
