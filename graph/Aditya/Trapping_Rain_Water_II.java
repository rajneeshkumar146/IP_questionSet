package june3;

import java.util.PriorityQueue;

public class Trapping_Rain_Water_II {

	public static void main(String[] args) {

		int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
		System.out.println(trapRainWater(heightMap));
	}

	static int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
			return 0;

		int atmaxwecanfill = Integer.MIN_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
		boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];

		for (int i = 0; i < heightMap.length; i++) {
			pq.add(new int[] { i, 0, heightMap[i][0] });
			pq.add(new int[] { i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1] });
			visited[i][0] = visited[i][heightMap[0].length - 1] = true;

		}

		for (int i = 0; i < heightMap[0].length; i++) {
			pq.add(new int[] { 0, i, heightMap[0][i] });
			pq.add(new int[] { heightMap.length - 1, i, heightMap[heightMap.length - 1][i] });
			visited[0][i] = visited[heightMap.length - 1][i] = true;
		}

		int ans = 0;

		while (pq.size() != 0) {
			int[] cellData = pq.poll();
			atmaxwecanfill = Math.max(atmaxwecanfill, heightMap[cellData[0]][cellData[1]]);

			for (int i = 0; i < 4; i++) {
				int x = cellData[0] + direction[i][0];
				int y = cellData[1] + direction[i][1];

				if (x < 0 || y < 0 || x >= heightMap.length || y >= heightMap[0].length || visited[x][y] == true) {
					continue;
				}

				visited[x][y] = true;
				if (heightMap[x][y] <= atmaxwecanfill) {
					ans += (atmaxwecanfill - heightMap[x][y]);
				}

				pq.add(new int[] { x, y, heightMap[x][y] });

			}
		}

		return ans;

	}
}
