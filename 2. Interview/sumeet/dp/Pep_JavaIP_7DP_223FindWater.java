package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_223FindWater {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int row = scn.nextInt();
		int col = scn.nextInt();
		
		System.out.println(solve(n, row, col));
	}
	
	private static double solve(int n, int row, int col){ 
		double[][] dp = new double[row + 1][row + 1];
		dp[1][1] = n;
		
		for(int r = 1; r <= row; r++){
			for(int c = 1; c <= r; c++){
				if(r < row && dp[r][c] > 1){
					double spare = dp[r][c] - 1; 
					dp[r][c] = 1;
					dp[r + 1][c] += spare / 2;
					dp[r + 1][c + 1] += spare / 2;
				}
			}
		}
		
		return dp[row][col] > 1? 1: dp[row][col];
	}
}

// https://www.geeksforgeeks.org/find-water-in-a-glass/
/* Test case 1 
2
2 2
0.5
*/

/* Test case 2 
4
3 2
0.5
*/
