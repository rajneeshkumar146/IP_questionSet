package interview.dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_236LCIS {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] one = new int[scn.nextInt()];
		for(int i = 0; i < one.length; i++){
			
			one[i] = scn.nextInt();
		}
		
		int[] two = new int[scn.nextInt()];
		for(int i = 0; i < two.length; i++){
			two[i] = scn.nextInt();
		}
		
		System.out.println(solve(one, two));
	}
	
	// something like running lis on two many times, once for each item of one
	private static int solve(int[] one, int[] two){
		// stores the length of lcis ending at two[j]
		int[] dp = new int[two.length];


		// in a particular iteration, one is considered till i and two till j
		// when both i and j reaches end, problem finishes
		for(int i = 0; i < one.length; i++){
			int current = 0;
			
			for(int j = 0; j < two.length; j++){
				if(one[i] == two[j]){
					if(current + 1 > dp[j]){
						dp[j] = current + 1;
					}
				} else if(two[j] < one[i]){ 
					// We are considering all those lcis which end at values smaller than one[i] and are formed with elements
					// from 0 to i - 1 in one and 0 to j in two;
					// The conditions here meet the above criteria, lcis ending at this j has been treated with elements 
					// 0 to i - 1 in one and also end at a value smaller than one[i]
					if(dp[j] > current){
						// someone to the left of i (and smaller than one[i]) may have been equal to two[j]
						current = dp[j];
					}
				}
			}
		}
		
		int len = Integer.MIN_VALUE;
		for(int val: dp){
			len = Math.max(len, val);
		}
		return len;
	}
	
}

// https://www.geeksforgeeks.org/longest-common-increasing-subsequence-lcs-lis/
/* Test case 1 
4
3 4 9 1
7
5 3 8 9 10 2 1
2
*/

/* Test case 2 
5
9 6 3 8 10
7
3 8 6 5 9 4 10
3
*/
