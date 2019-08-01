package june1;

import java.util.HashMap;

public class grid_illumination {
	public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {

		HashMap<Integer, Integer> rowlamps = new HashMap<>();
		HashMap<Integer, Integer> collamps = new HashMap<>();
		HashMap<Integer, Integer> diagonalp45 = new HashMap<>(); // y=x+c
		HashMap<Integer, Integer> diagonaln45 = new HashMap<>(); // y=-x+c
		HashMap<Integer, Boolean> lampONOFF = new HashMap<>();

		for (int i = 0; i < lamps.length; i++) {
			int x = lamps[i][0];
			int y = lamps[i][1];

			rowlamps.put(x, rowlamps.getOrDefault(x, 0) + 1);
			collamps.put(y, collamps.getOrDefault(y, 0) + 1);
			diagonalp45.put(x - y, rowlamps.getOrDefault(x - y, 0) + 1);
			diagonaln45.put(x + y, collamps.getOrDefault(x + y, 0) + 1);
			lampONOFF.put(N * x + y, true);
		}

		int[] ans = new int[queries.length];
		// address queries
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0];
			int y = queries[i][1];

			ans[i] = (rowlamps.getOrDefault(x, 0) > 0 || collamps.getOrDefault(y, 0) > 0
					|| diagonalp45.getOrDefault(x - y, 0) > 0 || diagonaln45.getOrDefault(x + y, 0) > 0) ? 1 : 0;
			// switch off the lamps, if any

			int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 },
					{ 0, 0 } };
			for (int d = 0; d < dirs.length; d++) {
				int x1 = x + dirs[d][0];
				int y1 = y + dirs[d][1];
				if (lampONOFF.containsKey(N * x1 + y1) && lampONOFF.get(N * x1 + y1)) {
					// the lamp is on, turn it off, so decrement the count of
					// the lamps
					rowlamps.put(x1, rowlamps.getOrDefault(x1, 1) - 1);
					collamps.put(y1, collamps.getOrDefault(y1, 1) - 1);
					diagonalp45.put(x1 - y1, diagonalp45.getOrDefault(x1 - y1, 1) - 1);
					diagonaln45.put(x1 + y1, diagonaln45.getOrDefault(x1 + y1, 1) - 1);
					lampONOFF.put(N * x1 + y1, false);
				}
			}

		}

		return ans;

	}
}
