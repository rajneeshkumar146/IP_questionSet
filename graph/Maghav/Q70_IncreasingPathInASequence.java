
public class Q70_IncreasingPathInASequence {
	    public int longestIncreasingPath(int[][] matrix) {
	       if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
				return 0;

			int max = 0, n = matrix.length, m = matrix[0].length;

		
			int[][] dp = new int[n][m];
		    
	       //any cell dp[i][j] denotes the maximum length increasing sequence that can be      
			//created by taking this cell as the starting point


			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					max = Math.max(dfs(matrix, Integer.MIN_VALUE, i, j, n, m, dp), max);
				}
			}
			return max;
		}

		int dfs(int[][] matrix, int min, int i, int j, int n, int m, int[][] dp) {

			
			if (i < 0 || j < 0 || i >= n || j >= m)
				return 0;

			
			if (matrix[i][j] <= min)  // Key step as this will prevent stack overflow
				return 0;

			
			if (dp[i][j] != 0)
				return dp[i][j];

			
			min = matrix[i][j];

			
			int a = dfs(matrix, min, i - 1, j, n, m, dp) + 1;
			int b = dfs(matrix, min, i + 1, j, n, m, dp) + 1;
			int c = dfs(matrix, min, i, j - 1, n, m, dp) + 1;
			int d = dfs(matrix, min, i, j + 1, n, m, dp) + 1;

			
			int max = Math.max(a, Math.max(b, Math.max(c, d)));
			dp[i][j] = max;

			return max;
		}
	        

}
