package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_230PrintTargetSum {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int tar = scn.nextInt();
		
		solve(arr, tar);
	}
	
	// old question, doing for printing
	private static void solve(int[] arr, int tar){ 
		boolean[][] dp = new boolean[arr.length + 1][tar + 1];
		
		for(int item = 0; item <= arr.length; item++){
			for(int t = 0; t <= tar; t++){
				if(item == 0 && t == 0){
					dp[item][t] = true;
				} else if(item == 0){
					dp[item][t] = false;
				} else if(t == 0){
					dp[item][t] = true;
				} else {
					dp[item][t] = dp[item - 1][t];
					
					if(t >= arr[item - 1]){
						dp[item][t] |= dp[item - 1][t - arr[item - 1]];
					}
				}
			}
		}
		
		printPath(dp, arr.length, tar, arr, "");
	}
	
	private static void printPath(boolean[][] dp, int item, int tar, int[] arr, String psf){
		if(tar == 0){
			System.out.println(psf);
			return;
		}
		
		if(item == 0){
			return;
		}
		
		if(dp[item - 1][tar]){
			printPath(dp, item - 1, tar, arr, psf);
		}
		
		if(tar >= arr[item - 1] && dp[item - 1][tar - arr[item - 1]]){
			printPath(dp, item - 1, tar - arr[item - 1], arr, arr[item - 1] + " " + psf);
		}
	}
}

// https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
/* Test case 1 
5
1 2 3 4 5
10
1 2 3 4 
2 3 5 
1 4 5 
*/

/* Test case 2 
6
2 3 5 6 8 10
10
2 3 5 
2 8 
10 
*/
