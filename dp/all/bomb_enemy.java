package june5;

public class bomb_enemy {
	public int maxKilledEnemies(char[][] grid) {
		int n = grid.length;
		int m = n != 0 ? grid[0].length : 0;
		if (m == 0 || n == 0)
			return 0;

		int rowkill = 0;
		int[] colkill = new int[m];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (j == 0 || grid[i][j - 1] == 'W') {
					rowkill = 0;

					for (int k = j; k < m && grid[i][k] != 'W'; k++) {
						if (grid[i][k] == 'E') {
							rowkill++;
						}
					}

				}

				if (i == 0 || grid[i - 1][j] == 'W') {
					colkill[j] = 0;

					for (int k = i; k < n && grid[k][j] != 'W'; k++) {
						if (grid[k][j] == 'E') {
							colkill[j]++;
						}
					}

				}

				if (grid[i][j] == '0') {
					ans = Math.max(ans, rowkill + colkill[j]);
				}
			}

		}

		return ans;
	}
}
