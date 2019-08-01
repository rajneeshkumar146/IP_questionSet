package interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Pep_JavaIP_7DP_235LongestRepeatingSequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		
		System.out.println(solve(str));
	}

	// lcs with condition same characters should come at different indices
	private static int solve(String str){
		int[][] dp = new int[str.length() + 1][str.length() + 1];
		
		for(int i = str.length() - 1; i >= 0; i--){
			for(int j = str.length() - 1; j >= 0; j--){
				char ch1 = str.charAt(i);
				char ch2 = str.charAt(j);
				
				if(ch1 == ch2 && i != j){
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		
		return dp[0][0];
	}

}

// https://www.geeksforgeeks.org/longest-repeating-subsequence/
/* Test case 1 
axxxy
2
*/

/* Test case 2 
aabb
2
*/

/* Test case 3 
abc
0
*/