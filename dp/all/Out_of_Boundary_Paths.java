package InternQuestionDP;

public class Out_of_Boundary_Paths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPaths(2, 2, 2, 0, 0));
	}

	public static int findPaths(int m, int n, int N, int i, int j) {
        int MOD = 1000000007;
        int[][][] dp = new int[N+1][m][n];
        for (int k = 1; k <= N; k++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int move = 0;

                    // up
                    if (r == 0) {
                        move++;
                    } else {
                        move += dp[k-1][r-1][c];
                    }
                    move %= MOD;
                    
                    // down
                    if (r == m-1) {
                        move++;                        
                    } else {
                        move += dp[k-1][r+1][c];
                    }
                    move %= MOD;                    
                    
                    // left
                    if (c == 0) {
                        move++;
                    } else {
                        move += dp[k-1][r][c-1];
                    }
                    move %= MOD;                    
                    
                    // right
                    if (c == n-1) {
                        move++;
                    } else {
                        move += dp[k-1][r][c+1];
                    }
                    move %= MOD;                    
                    
                    dp[k][r][c] = move;
                }
            }
        }
        return dp[N][i][j];
    }

}
