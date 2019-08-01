package june2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class cut_off_trees_for_golf_event {
	int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int cutOffTree(List<List<Integer>> forest) {
		// create a list of int[] {value, x, y}
		List<int[]> trees = new ArrayList<>();
		for (int i = 0; i < forest.size(); i++) {
			for (int j = 0; j < forest.get(0).size(); j++) {
				int value = forest.get(i).get(j);
				if (value > 1)
					trees.add(new int[] { i, j, value });
			}
		}

		Collections.sort(trees, (a, b) -> (a[2] - b[2]));
		int res = 0, x = 0, y = 0;

		for (int[] tree : trees) {
			int dist = bfs(forest, x, y, tree[0], tree[1]);
			if (dist < 0)
				return -1;
			else {
				res += dist;
				x = tree[0];
				y = tree[1];
			}
		}
		return res;
	}

	private int bfs(List<List<Integer>> forest, int x, int y, int tx, int ty) {
		int m = forest.size(), n = forest.get(0).size();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		boolean[][] visited = new boolean[m][n];
		visited[x][y] = true;
		int dist = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				int[] cur = queue.poll();
				if (cur[0] == tx && cur[1] == ty)
					return dist;
				for (int i = 0; i < 4; i++) {
					int nx = cur[0] + dirs[i][0];
					int ny = cur[1] + dirs[i][1];
					if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] || forest.get(nx).get(ny) <= 0)
						continue;
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}
			}
			dist++;
		}
		return -1;
	}
}
