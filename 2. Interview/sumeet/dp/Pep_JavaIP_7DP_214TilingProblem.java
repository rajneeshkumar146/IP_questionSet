package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// simple tiling is fibonnaci - https://www.geeksforgeeks.org/tiling-problem/
public class Pep_JavaIP_7DP_214TilingProblem {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		
		System.out.println(solve(n, m));
	}
	
	private static int solve(int n, int m){
		int[] dp = new int[n + 1];
		
		for(int i = 1; i < dp.length; i++){
			if(i > m){
				dp[i] = dp[i - 1] + // placed vertically
						dp[i - m]; // placed horizontally (now will have to put m - 1 tiles horizontally
			} else if(i == m){
				dp[i] = 2; // two options - horizontally or verticcally
			} else {
				dp[i] = 1;
			}
		}
		
		return dp[n];
	}
}

// https://www.geeksforgeeks.org/count-number-ways-tile-floor-size-n-x-m-using-1-x-m-size-tiles/
/* Test case 1 
4 3
3
*/

/* Test case 2 
5 2
8
*/
