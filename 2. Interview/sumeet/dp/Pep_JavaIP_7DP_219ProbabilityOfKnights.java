package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_219ProbabilityOfKnights {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int x = scn.nextInt();
		int y = scn.nextInt();
		int k = scn.nextInt();
		
		System.out.println(solve(n, x, y, k));
	}
	
	private static double solve(int n, int x, int y, int k){
		double[][][] dp = new double[n + 1][n + 1][k + 1];
		
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= n; j++){
				dp[i][j][0] = 1;
			}
		}
		
		int[][] dirs = {
				{1, 2},
				{1, -2},
				{-1, 2},
				{-1, -2},
				{2, 1},
				{2, -1},
				{-2, 1},
				{-2, -1}
		};
		
		for(int run = 1; run <= k; run++){
			for(int i = 0; i <= n; i++){
				for(int j = 0; j <= n; j++){
					for(int dir = 0; dir < dirs.length; dir++){
						int idash = i + dirs[dir][0];
						int jdash = j + dirs[dir][1];
						
						if(idash >= 0 && idash <= n && jdash >= 0 && jdash <= n){
							dp[i][j][run] += dp[idash][jdash][run - 1] / 8.0;
						}
					}
					
				}
			}
		}
		
		return dp[x][y][k];
	}
}

// https://www.geeksforgeeks.org/probability-knight-remain-chessboard/
/* Test case 1 
8
0 0 
3
0.125
*/

/* Test case 2 
5
2 3
3
0.359375
*/
